import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirGC extends WritableComparator {
    AirGC() {
        super(AirWC.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return ((AirWC)a).getId() - ((AirWC)b).getId();
    }
}
