import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

import javax.xml.soap.Text;

public class AirPartitioner extends HashPartitioner<AirWC, Text> {

    @Override
    public int getPartition(AirWC key, Text value, int numReduceTasks) {
        return(key)

    }
}
