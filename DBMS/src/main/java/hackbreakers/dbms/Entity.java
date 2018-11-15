
import java.io.Serializable;
import java.util.ArrayList;
        
public class Entity {
    
    private String name;
    private DataType dataType;
    private int size;
    private List<Attribute> attributes = new ArrayList<Attribute>();
    
    public Entity() {
        
    }
    
    public Entity(String name , DataType dataType , int size) {
        
    }
    
    public void setname(String name) {
        this.name = name;
    }
    
    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public String getName() {
        return name;
    }
    
    public DataType getDataType() {
        return dataType;
    }
    
    public int getSize() {
        return size;
    }
}