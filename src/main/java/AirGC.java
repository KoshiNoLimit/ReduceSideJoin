import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirGC extends WritableComparator<AirWC> {
    @Override
    public int compare(AirWC a, AirWC b) {
        return a.getId() - b.getId();
    }
}
