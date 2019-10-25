import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirGC extends WritableComparator {
    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return a.getId() - b.getId();
    }
}
