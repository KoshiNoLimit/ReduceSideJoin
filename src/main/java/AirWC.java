import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class AirWC implements WritableComparable<AirWC> {
    private int id;
    private int ind;
    

    public AirWC(int id, int ind) {
        this.id = id;
        this.ind = ind;
    }

    int getId() {
        return this.id;
    }

    @Override
    public int compare(AirWC o) {
        if(this.id == o.id) return(this.ind < o.ind ? -1 : 1);
        else return (this.id < o.id ? -1 : 1);
    }

//    @Override
//    public void write(DataOutput dataOutput) throws IOException {
//        dataOutput.writeInt(this.id);
//        dataOutput.writeInt(this.ind);
//    }
//
//    @Override
//    public void readFields(DataInput dataInput) throws IOException {
//        this.id = dataInput.readInt();
//        this.ind = dataInput.readInt();
//    }
}