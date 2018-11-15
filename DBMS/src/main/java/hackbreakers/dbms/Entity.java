package hackbreakers.dbms;

import java.io.Serializable;
import java.util.List;

public class Entity implements Serializable { //Description of each entity

    private String name;
    private List<Attribute> attributes;// A list of description of attributes

    public Entity() {
    }

    public Entity(String name, List<Attribute> attributes) {
        this.name = name;
        this.attributes = attributes;
    }
    //Set methods
    public void setname(String name) {
        this.name = name;
    }
    
    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
    //Get methods
    public String getName() {
        return name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }
}
