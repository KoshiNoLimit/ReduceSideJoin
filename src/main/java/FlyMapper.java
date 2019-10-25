import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlyMapper extends Mapper <LongWritable, Text, AirWC, Text> {
    private static final int ID = 14;
    private static final int DELAY = 18;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] set = Parse.parse(value.toString(), 1);
        if(set.length != 0) {
            context.write(new AirWC(Integer.parseInt(set[ID]), 1), new Text(set[DELAY]));
        }
    }
}