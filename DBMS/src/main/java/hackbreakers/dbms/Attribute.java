package hackbreakers.dbms;

import java.io.Serializable;

public class Attribute implements Serializable {//Contains: 4 methods, 34 lines.
//This class describes each attribute.

    private String name;
    private DataType dataType;

    public Attribute() {
    }

    public Attribute(String name, DataType dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDatatype(DataType dataType) {
        this.dataType = dataType;
    }

    public DataType getDatatype() {
        return this.dataType;
    }
}
