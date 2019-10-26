import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlyMapper extends Mapper <LongWritable, Text, AirWC, Text> {
    private static final Integer ID = 14;
    private static final Integer DELAY = 18;
    private static final Integer IND = 1;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if( key.get() != 0) {
            String[] set = Parse.parse(value.toString(), IND);
            if (set != Parse.EMPTY) {
                context.write(new AirWC(Integer.parseInt(set[ID]), IND), new Text(set[DELAY]));
            }
        }
    }
}