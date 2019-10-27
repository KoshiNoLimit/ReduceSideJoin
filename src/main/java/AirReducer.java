import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class AirReducer extends Reducer<AirWC, Text, Text, Text> {

    @Override
    protected void reduce(AirWC key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> textIterator = values.iterator();
        String name = textIterator.next().toString();
        if(textIterator.hasNext()) {
            double size = 0, min = Double.MAX_VALUE, med = 0, max = 0;
            for (; textIterator.hasNext(); size++) {
                String check = textIterator.next().toString();
                if(check.equals("")) continue;
                double x = Double.parseDouble(check);
                if (x < min) {
                    min = x;
                } else if (x > max) {
                    max = x;
                }
                med += x;
            }
            context.write(new Text(name), new Text(" median=" + med / size + " min=" + min + " max=" + max));
        }
    }
}
