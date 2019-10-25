import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class AirPartitioner extends HashPartitioner {

    @Override
    public int getPartition(Object key, Object value, int numReduceTasks) {
        
    }
}
