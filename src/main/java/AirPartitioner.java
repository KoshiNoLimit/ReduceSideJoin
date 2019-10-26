import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class AirPartitioner extends HashPartitioner<AirWC, Text> {

    @Override
    public int getPartition(AirWC key, Text value, int numReduceTasks) {
        return (key.getId().hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}
