import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirWC implements WritableComparable<AirWC> {
    private Integer id;
    private Integer ind;

    protected AirWC() {
        this.id = 0;
        this.ind = 0;
    }

    AirWC(Integer id, Integer ind) {
        this.id = id;
        this.ind = ind;
    }

    Integer getId() {
        return this.id;
    }

    @Override
    public int compareTo(AirWC o) {
        if(this.id.equals(o.id)){
            if(this.ind.equals(o.ind)) return 0;
            return(this.ind < o.ind ? -1 : 1);
        }
        return (this.id < o.id ? -1 : 1);
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.id);
        dataOutput.writeInt(this.ind);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.id = dataInput.readInt();
        this.ind = dataInput.readInt();
    }
}