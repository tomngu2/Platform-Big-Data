package com.sparkTutorial.rdd;

import static org.apache.spark.sql.functions.col;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.RelationalGroupedDataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Case_Study_2_2_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Logger.getLogger("org").setLevel(Level.ERROR);
		   SparkConf conf = new SparkConf().setAppName("CDW_SAPP").setMaster("local[1]");

	       JavaSparkContext sc = new JavaSparkContext(conf);
	       SparkSession session = SparkSession.builder().appName("CDW_SAPP_Tables").master("local[1]")
	               .getOrCreate();
	       
	       // For 2-2-5 Problem #2
	       JavaRDD<String> externalDataBranch = sc.textFile("hdfs://192.168.40.128:8020/credit_card_system/CDW_SAPP_BRANCH/part-m-00000");
	       JavaRDD<ResponseA> responseARDD = externalDataBranch.map(line -> { 
	    	   String split[] = line.split(",");
	    	   return new ResponseA(Integer.parseInt(split[0]), split[1], split[2], split[3], split[4], split[5],split[6], split[7]);
	       });
	    	
	       Dataset <ResponseA> responseDataSetBranch = session.createDataset(responseARDD.rdd(), Encoders.bean(ResponseA.class));
		
	       RelationalGroupedDataset groupedDatasetBranch = responseDataSetBranch.groupBy(col("state"));
	       
	       Dataset<Row> countgroupedDatasetBranch = groupedDatasetBranch.count().orderBy(col("count").desc());
	       countgroupedDatasetBranch.repartition(1).write().format("csv").option("header",true).
	       save("hdfs://192.168.40.128:8020/credit_card_system/2-2-5#2_Output");
	       
	       
	       // For 2-2-5 Problem #3
	       JavaRDD<String> externalDataCreditCard = sc.textFile("hdfs://192.168.40.128:8020/credit_card_system/CDW_SAPP_CREDITCARD/part-m-00000");
	       JavaRDD<ResponseB> responseBRDD = externalDataCreditCard.map(line -> { 
	    	   String split[] = line.split(",");
	    	   return new ResponseB(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 
	    			   Integer.parseInt(split[3]), split[4], Integer.parseInt(split[5]),Integer.parseInt(split[6]), 
	    			   split[7], Float.parseFloat(split[8]));
	       });
	       
	       Dataset <ResponseB> responseDataSetCreditcard = session.createDataset(responseBRDD.rdd(), Encoders.bean(ResponseB.class));
	     
	       RelationalGroupedDataset groupedDatasetCreditcard = responseDataSetCreditcard.groupBy(col("cust_ssn"));
	       
	       Dataset<Row> countgroupedDatasetCreditcard = groupedDatasetCreditcard.count().orderBy(col("count").desc());
	       countgroupedDatasetCreditcard.repartition(1).write().format("csv").option("header",true).
	       save("hdfs://192.168.40.128:8020/credit_card_system/2-2-5#3_Output");
	       
	       
	       // For 2-2-5 Problem #4
	       Dataset<Row> joined = responseDataSetBranch
   		   		.join(responseDataSetCreditcard, responseDataSetBranch.col("branch_code")
   		   				.equalTo(responseDataSetCreditcard.col("branch_code")));
      
	       RelationalGroupedDataset groupedDatasetBranchCreditcard =
	    		   joined.select(col("state"), col("transaction_id")).groupBy(col("state"));       
	       // groupedDatasetBranchCreditcard.count().orderBy(col("count").desc()).show(30);
      
	       Dataset<Row> countgroupedDatasetBranchCreditcard = groupedDatasetBranchCreditcard.count().orderBy(col("count").desc());
	       countgroupedDatasetBranchCreditcard.repartition(1).write().format("csv").option("header",true).
	       save("hdfs://192.168.40.128:8020/credit_card_system/2-2-5#4_Output");
	       
	       
	       session.stop();
		
	}

}
