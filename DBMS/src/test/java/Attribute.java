import java.io.Serializable;

public class Attribute implements Serializable {//Description of each attribute

    private String name;
    private DataType dataType;
    private int size;

    public Attribute() {

    }

    public Attribute(String name, DataType dataType, int size) {
        this.name = name;
        this.dataType = dataType;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDatype(DataType dataType) {
        this.dataType = dataType;
    }

    public DataType getDatype() {
        return this.dataType;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}
