import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirWC implements WritableComparable<AirWC> {
    private int id;
    private int ind;

    AirWC(int id, int ind) {
        this.id = id;
        this.ind = ind;
    }

    int getId() {
        return id;
    }

    @Override
    public int compareTo(AirWC o) {
        if(id == o.id) return(ind < o.ind ? -1 : 1);
        else return (id < o.id ? -1 : 1);
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
