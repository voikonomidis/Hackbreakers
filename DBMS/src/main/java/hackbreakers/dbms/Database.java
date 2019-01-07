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

    public List<String> fetchDatabasesGUI() {//It is used by comboBox during editing of a specific database.
        List<String> dbList = new ArrayList();
        File[] files = new File(".").listFiles();
        for (File f : files) {
            if (f.isDirectory() && f.getName().startsWith("db_")) {
                dbList.add(f.getName().replace("db_", ""));
            }
        }
        return dbList;
    }

    public List<Entity> fetchDatabaseEntitiesGUI(String dbName) {//Returns only the Entity objects. It's used for loading the jTree.
        List<Entity> entList = new ArrayList();
        String pathDbmsName = "db_" + dbName + "/" + dbName + ".sys";
        try {
            RandomAccessFile raf = new RandomAccessFile(pathDbmsName, "rwd");
            while (raf.getFilePointer() != raf.length()) {//Reading whole file sequentially.
                raf.seek(raf.getFilePointer());
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(raf.getFD()));
                Entity entity = (Entity) ois.readObject();
                int cnt = 1;
                for (Attribute attr : entity.getAttributes()) {
                    System.out.print(attr.getName());
                    if (cnt != entity.getAttributes().size()) {
                        System.out.print(",");
                    }
                    ++cnt;
                }
                System.out.println(")");
                entList.add(entity);
            }
            raf.close();
        } catch (IOException ex) {
            System.out.println("IO EXCEPTION");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("CLASS NOT FOUND EXCEPTION");
            ex.printStackTrace();
        }
        return entList;
    }

    public Entity fetchDatabaseEntityByNameGUI(String dbName, String entityName) {//It's used for loading the tabbedPane "table info".
        Entity ent = new Entity();
        String pathDbmsName = "db_" + dbName + "/" + dbName + ".sys";
        try {
            RandomAccessFile raf = new RandomAccessFile(pathDbmsName, "rwd");
            while (raf.getFilePointer() != raf.length()) {//Reading whole file sequentially
                raf.seek(raf.getFilePointer());
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(raf.getFD()));
                Entity entity = (Entity) ois.readObject();
                if (entity.getName().equals(entityName)) {
                    ent = entity;
                    break;
                }
            }
            raf.close();
        } catch (IOException ex) {
            System.out.println("IO EXCEPTION");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("CLASS NOT FOUND EXCEPTION");
            ex.printStackTrace();
        }
        return ent;
    }

}
