import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class AirComparator extends WritableComparator {

    protected AirComparator() {
        super(AirWC.class, true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        return ((AirWC)a).getId().compareTo(((AirWC)b).getId());
    }
}
