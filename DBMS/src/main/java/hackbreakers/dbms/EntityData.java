package hackbreakers.dbms;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntityData implements Serializable {//Contains: 9 methods, 62 lines.
//This class describes the data object corresponding to each Entity ddl.

    private Entity entity;//It's used for mapping among ddl and data
    private LocalDate dateOfCreation;
    private List<Object> record = new ArrayList();//Takes the records of each EntityData. Is stored as an object in RandomAccessFile.
    private int deleted; //0 no, 1 yes - Is a flag. Is used when the user wants to update or delete an EntityData object

    public EntityData() {
    }

    public EntityData(Entity entity, LocalDate dateOfCreation, List<Object> record, int deleted) {
        this.entity = entity;
        this.dateOfCreation = dateOfCreation;
        this.record = record;
        this.deleted = deleted;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public void setRecord(List<Object> record) {
        this.record = record;
    }

    public Entity getEntity() {
        return entity;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public List<Object> getRecord() {
        return record;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getDeleted() {
        return deleted;
    }

    @Override
    public String toString() {
        return "EntityData{" + "entity=" + entity + ", dateOfCreation=" + dateOfCreation + ", record=" + record + ", deleted=" + deleted + '}';
    }
}