/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Bill
 */
public class Attribute {

    private String attributeName;
    private String attributeDataType;
    private short attributeDataTypeSize;

    public Attribute() {
    }

    public Attribute(String attributeName, String attributeDataType, short attributeDataTypeSize) {
        this.attributeName = attributeName;
        this.attributeDataType = attributeDataType;
        this.attributeDataTypeSize = attributeDataTypeSize;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeDataType() {
        return attributeDataType;
    }

    public void setAttributeDataType(String attributeDataType) {
        this.attributeDataType = attributeDataType;
    }

    public short getAttributeDataTypeSize() {
        return attributeDataTypeSize;
    }

    public void setAttributeDataTypeSize(short attributeDataTypeSize) {
        this.attributeDataTypeSize = attributeDataTypeSize;
    }

}
