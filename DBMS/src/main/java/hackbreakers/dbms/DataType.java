package hackbreakers.dbms;

import java.io.Serializable;

public class DataType implements Serializable {//Contains: 2 methods, 24 lines.
//This class describes each attribute's datatype that user can inserts.

    private String name; //Numeric, Characters, Boolean or Date.

    public DataType() {
    }

    public DataType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
