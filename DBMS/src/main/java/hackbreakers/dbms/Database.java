package hackbreakers.dbms;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {//Contains: 16 methods, 353 lines.
//This class includes the methods that materialize the main functions of our app.
    
    private String name;
    private List<Entity> entities;
    private RandomAccessFile dbmsFile;//File that stores ddl of each database.
    private RandomAccessFile databaseFile;//File that stores data of each database.

    public Database() {
    }

    public Database(String name, List<Entity> entities, RandomAccessFile dbmsFile, RandomAccessFile databaseFile) {
        this.name = name;
        this.entities = entities;
        this.dbmsFile = dbmsFile;
        this.databaseFile = databaseFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }

    public RandomAccessFile getDbmsFile() {
        return dbmsFile;
    }

    public void setDbmsFile(RandomAccessFile dbmsFile) {
        this.dbmsFile = dbmsFile;
    }

    public RandomAccessFile getDatabaseFile() {
        return databaseFile;
    }

    public void setDatabaseFile(RandomAccessFile databaseFile) {
        this.databaseFile = databaseFile;
    }

}
