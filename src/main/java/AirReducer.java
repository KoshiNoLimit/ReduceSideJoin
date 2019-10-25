import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class AirReducer extends Reducer {

    @Override
    protected void reduce(AirWC key, Iterable values, Context context) throws IOException, InterruptedException {

    }
}
