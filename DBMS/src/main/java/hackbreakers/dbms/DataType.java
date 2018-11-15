package hackbreakers.dbms;

import java.io.Serializable;

public class DataType implements Serializable{
    //Μπορούμε να προσθέσουμε μια λίστα με τους τύπους που μπορεί να δώσει στη μεταβλητή ο χρήστης
    private String name; //Το όνομα του datatype σε " ". Μπορει να παίρνει τους τύπους Int, String, Boolean, Date, other...

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