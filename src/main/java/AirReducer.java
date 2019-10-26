import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirReducer extends Reducer<AirWC, Text, Text, Text> {

    @Override
    protected void reduce(AirWC key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> set = values.iterator();

        String name = set.next().toString();
        if(set.hasNext()) {
            double size = 0;
            double min = 0, med = 0, max = Double.MAX_VALUE;
            for (; set.hasNext(); size++) {
                double x = Double.parseDouble(set.next().toString());
                if (x < min) {
                    min = x;
                } else if (x > max) {
                    max = x;
                }
                med += x;
            }
            context.write(new Text(name), new Text(" median=" + med/size + " min=" + min + " max=" + max ));
        }

    }
}
