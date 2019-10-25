import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirMapper extends Mapper <LongWritable, Text, AirWC, Text> {
    private static final int ID = 0;
    private static final int NAME = 1;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] set = value.toString().split(",");
        for (int i = 0; i < set.length; i++) {
            set[i] = set[i].replaceAll("\"", "");
        }
        context.write(new AirWC(Integer.parseInt(set[ID]), 0), new Text(set[NAME]));
    }
}
