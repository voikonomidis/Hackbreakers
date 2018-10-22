/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.io.IOException;
import java.io.OptionalDataException;

/**
 *
 * @author Bill
 */
public class Database {
    
    private String databaseName;
    private int databaseSize;
    private RecordsFile recordsFile;
    
    public Database() {
    }

    public Database(String databaseName, int databaseSize) throws IOException, RecordsFileException {
        this.databaseName = databaseName;
        this.databaseSize = databaseSize;
        
        if(!(new File(databaseName)).exists())
            this.recordsFile= new RecordsFile(databaseName, databaseSize); //create database
        else
            this.recordsFile= new RecordsFile(databaseName, "r"); //open database for read
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public int getDatabaseSize() {
        return databaseSize;
    }

    public void setDatabaseSize(int databaseSize) {
        this.databaseSize = databaseSize;
    }
    
    public void insert(int cnt, String str) throws IOException, RecordsFileException{
        RecordWriter rec = new RecordWriter(" " + cnt);
        rec.writeObject(str);
        this.recordsFile.insertRecord(rec);
    }
    
    public String select(int cnt) throws RecordsFileException, IOException, OptionalDataException, ClassNotFoundException{
        RecordReader rr = recordsFile.readRecord(" " + cnt);
        String str = (String) rr.readObject();
        return str;
    }
}
