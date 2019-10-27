import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirMapper extends Mapper <LongWritable, Text, AirWC, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if( key.get() != 0) {
            String[] set = ParseAF.parseAir(value.toString());
            if(set.length != 0) {
                context.write(new AirWC(Integer.parseInt(set[ParseAF.AIRPORT_ID]), ParseAF.AIRPORT_IND), new Text(set[ParseAF.AIRPORT_NAME]));
            }
        }
    }
}
