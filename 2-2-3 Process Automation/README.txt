1.  Run oozie command in linux to start Oozie.
2.  Workflow will start to drop all tables with drop_tables.hive script.
3.  Workflow next will scoop import all tables into HDFS.
4.  Workflow next will create and load temp tables with file temp_tables.hive script.
5.  Workflow next will create and load partiitoned tables with file partitioned_tables.hive script.

Note:  drop_tables.hive, partitioned_tables.hive, password.txt, temp_tables.hive, and workflow.xml
are stored in /user/maria_dev/oozie_case_study/2-2-3/