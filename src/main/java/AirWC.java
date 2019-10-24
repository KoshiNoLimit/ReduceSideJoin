import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirWC implements WritableComparable<AirWC> {
    private int id;
    private int ind;

    @Override
    public int compareTo(Object o) {
        if(id < o.id)
        return 0;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeInt(ind);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        id = dataInput.readInt();
        ind = dataInput.readInt();
    }
}
