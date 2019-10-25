import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirGC extends WritableComparator {
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        AirWC a1 = (AirWC) a;
        AirWC b1 = (AirWC) b;
        return a1.getId() - b1.getId();
        //return ((AirWC)a).getId() - ((AirWC)b).getId();
    }
}
