/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bill
 */
public class Entity {

    private String entityName;
    private List<Attribute> entityAttributes;
    private List<String> data;

    public Entity() {
    }

    public Entity(String entityName, Attribute... attributes) {
        this.entityName = entityName;
        this.entityAttributes = new ArrayList();
        this.entityAttributes.addAll(Arrays.asList(attributes));
    }

    public Entity(String entityName, List<Attribute> entityAttributes) {
        this.entityName = entityName;
        this.entityAttributes = entityAttributes;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<Attribute> getEntityAttributes() {
        return entityAttributes;
    }

    public void setEntityAttributes(List<Attribute> entityAttributes) {
        this.entityAttributes = entityAttributes;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
    
    

}
