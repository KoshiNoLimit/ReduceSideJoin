import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlyMapper extends Mapper <LongWritable, Text, AirWC, Text> {
    private static final int ID = 14;
    private static final int DELAY = 18;
    private static final int CANCEL = 19;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] set = value.toString().split(",");

        if( (set[CANCEL].equals(("1.00"))) || (set[DELAY].equals("0.00"))) {
            
        }

        for (int i = 0; i < set.length; i++) {
            set[i] = set[i].replaceAll("\"", "");
        }
        context.write(new AirWC(Integer.parseInt(set[ID]), 1), new Text(set[DELAY]));
    }
}