import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class AirReducer extends Reducer<AirWC, Text, Text, Text> {

    @Override
    protected void reduce(AirWC key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterable<Text> set = values.iterator();
    }
}
