
import java.io.Serializable;

public class Attribute implements Serializable {

    private String name;
    private DataType datype;
    private int size;

    public Attribute() {

    }

    public Attribute(String name, DataType datype, int size) {
        this.name = name;
        this.datype = datype;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDatype(DataType datype) {
        this.datype = datype;
    }

    public DataType getDatype() {
        return this.datype;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
