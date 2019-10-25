import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirMapper extends Mapper <LongWritable, Text, AirWC, Text> {
    private static final Integer ID = 0;
    private static final Integer NAME = 1;
    private static final Integer IND = 0;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] set = Parse.parse(value.toString(), IND);
        if(set.length != 0) {
            context.write(new AirWC(Integer.parseInt(set[ID]), IND), new Text(set[NAME]));
        }
    }
}
