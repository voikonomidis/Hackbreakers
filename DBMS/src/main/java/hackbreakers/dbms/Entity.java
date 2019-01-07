package hackbreakers.dbms;

import java.io.Serializable;
import java.util.List;

public class Entity implements Serializable {//Contains: 4 methods, 35 lines.
//This class describes each entity.

    private String name;
    private List<Attribute> attributes;

    public Entity() {
    }

    public Entity(String name, List<Attribute> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }
}
