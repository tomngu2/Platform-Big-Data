1.  Decided to create 4 additional temporary external tables to will receive new updates if RDBMS is updated.
2.  Coordinator frequency was set according to requirements document.
3.  Workflow will sqoop new data from CDW_SAPP RDBMS for new data.
4.  New data will be loaded into temporary external tables (update_external_tables.hive)
5.  Data from temporary external tables will be inserted into permanent partitioned tables (update_partitioned_tables.hive)

Note:  All files with the exception of job.properties will be loaded to /user/maria_dev/oozie_case_study/2-2-4
(coordinator.xml, password.txt, update_external_table.hive, update_partitioned_tables.hive, workflow.xml)

I already successfully tested 2-2-4 before, but I wanted to test one last time during the weekend before submission.  
Apparently, when I set the frequency according to the requirements, it won't run till Monday =P.  The output
shows Saturyday because I modified the frequency just to test the workflow and make sure incremental updates work.

