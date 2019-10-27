#bin/bash

hadoop fs -rm -r -f /user/knl/output
mvn package
hadoop fs -copyFromLocal AIR1.csv
hadoop fs -copyFromLocal TIME1.csv
export HADOOP_CLASSPATH=target/hadoop-examples-1.0-SNAPSHOT.jar
hadoop AirJoin AIR1.csv TIME1.csv output
hadoop fs -copyToLocal output