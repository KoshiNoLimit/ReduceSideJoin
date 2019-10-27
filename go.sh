#!bin/bash

hadoop fs -rm -r -f /user/knl/output
mvn package
hadoop AirJoin AIR1.csv TIME1.csv output
hadoop fs -copyToLocal output