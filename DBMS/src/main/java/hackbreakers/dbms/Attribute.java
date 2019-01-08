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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
}
