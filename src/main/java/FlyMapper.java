import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlyMapper extends Mapper <LongWritable, Text, AirWC, Text> {
    
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if( key.get() != 0) {
            String[] lines = ParseAF.parseFly(value.toString());
            if (lines.length != 0) {
                context.write(new AirWC(Integer.parseInt(lines[ParseAF.FLY_ID]), ParseAF.FLY_IND), new Text(lines[ParseAF.DELAY]));
            }
        }
    }
}