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
    
    public boolean createDatabaseGUI(String dbName) {//creates a database(directory) through the CreateDatabaseJDialog.
        boolean answer = false;
        if (new File("db_" + dbName).mkdirs()) {
            String pathDbmsName = "db_" + dbName + "/" + dbName + ".sys";
            String pathDbName = "db_" + dbName + "/" + dbName + ".db";
            try {
                this.dbmsFile = new RandomAccessFile(pathDbmsName, "rwd");
                this.databaseFile = new RandomAccessFile(pathDbName, "rwd");
                this.dbmsFile.close();
                this.databaseFile.close();
            } catch (FileNotFoundException ex) {
                System.out.println("Could not create Database files. Try again...");
            } catch (IOException ex) {
                System.out.println("Could not create Database files. Try again...");
            }
            System.out.println("Database " + dbName + " successfully created!");
            answer = true;
        } else {
            System.out.println("Could not create Database files. Try again...");
        }
        return answer;
    }

    public boolean createEntityGUI(String databaseName, String entityName, List<Attribute> attrList) {//creates multiple entities through the CreateEntityJDialog.
        boolean answer = false;
        Entity entity = new Entity(entityName, attrList);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream ooso;
        try {
            ooso = new ObjectOutputStream(baos);
            ooso.writeObject(entity);
            ooso.flush();
            String pathDbmsName = "db_" + databaseName + "/" + databaseName + ".sys";
            RandomAccessFile dbmsFile = new RandomAccessFile(pathDbmsName, "rwd");
            dbmsFile.seek(dbmsFile.length());//Goes to end of file.
            dbmsFile.write(baos.toByteArray());//Add entity in byte form to the end of file.
            System.out.println("Entity " + entity.getName() + " successfully created!");
            answer = true;
        } catch (IOException ex) {
            System.out.println("Entity " + entity.getName() + " COULD NOT be created!");
        }
        return answer;
    }

    public boolean storeEntityRecordGUI(String dbName, Entity entity, Object[] tuple, int insertUpdateDeleteMode) {//method responsible for insert, update or delete a record of an EntityData.
        // Every tuple includes the data of a "row" of a JTable in DataJPanel .
        boolean answer = false;
        String pathDbName = "db_" + dbName + "/" + dbName + ".db";
        LocalDate today = LocalDate.now();
        List<Attribute> attributeList = entity.getAttributes();//fetches the Attributes's description of the Entity.
        List<Object> record = Arrays.asList(tuple);//converts the array of object into list.
        for (Attribute attribute : attributeList) {//reads each one attribute by the same order that comes from the tuple.
            int entityAttributeIndex = attributeList.indexOf(attribute);
            switch (attribute.getDataType().getName()) {/*does the mapping among attributes's ddl and data stored in tuple - record.
                                                        Also checks the datatype of each attribute and converts it to the appropriate one before storing.*/
                case "Numeric":
                    Long number;
                    if (tuple[entityAttributeIndex] instanceof String) {//in case of updating.
                        number = Long.parseLong((String) tuple[entityAttributeIndex]);
                    } else {//in case of deleting
                        number = (Long) tuple[entityAttributeIndex];
                    }
                    record.set(entityAttributeIndex, number);
                    break;
                case "Characters":
                    String string = (String) tuple[entityAttributeIndex];
                    record.set(entityAttributeIndex, string);
                    break;
                case "Boolean":
                    Boolean bool;
                    if (tuple[entityAttributeIndex] instanceof String) {
                        bool = Boolean.parseBoolean((String) tuple[entityAttributeIndex]);
                    } else {
                        bool = (Boolean) tuple[entityAttributeIndex];
                    }
                    record.set(entityAttributeIndex, bool);
                    break;
                case "Date":
                    LocalDate date;
                    if (tuple[entityAttributeIndex] instanceof String) {
                        date = LocalDate.parse((String) tuple[entityAttributeIndex]);
                    } else {
                        date = (LocalDate) tuple[entityAttributeIndex];
                    }
                    record.set(entityAttributeIndex, date);
                    break;
                default:
                    break;
            }
        }

        try {//When user clicks on jtbale to select a specific row, or when he clicks on "new" to create one record.
            RandomAccessFile dbFile = new RandomAccessFile(pathDbName, "rw");
            if (insertUpdateDeleteMode == 1) { //Is used when the user clicks on "new" jbuttonPanel to insert data.
                System.out.println("INSERTING");
                EntityData entityData = new EntityData(entity, today, record, 0);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream ooso = new ObjectOutputStream(baos);
                ooso.writeObject(entityData);
                ooso.flush();
                dbFile.seek(dbFile.length()); //Go at the end of file.
                dbFile.write(baos.toByteArray()); // Add entity data in byte form to the end of file.
                baos.close();
                ooso.close();
            } else if (insertUpdateDeleteMode == 2) { //Is used when the user wants to update data on the jtable and save it via "save" jbuttonPanel.
                /*
                * When the user updates data on the Jtable (object EntityData), an instance of that particular object is being created.
                * The object takes the flag deleted = 1 and is stored as "deleted" in the (.db) and the instance
                * including the changed data is stored in the of the same file (.db) with the flag deleted = 0.
                 */
                System.out.println("UPDATING");
                EntityData newEntityData = new EntityData(entity, today, record, 0);//Row Selected
                while (dbFile.getFilePointer() != dbFile.length()) {
                    long filePointer = dbFile.getFilePointer();
                    dbFile.seek(dbFile.getFilePointer());
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dbFile.getFD()));
                    EntityData oldEntityData = (EntityData) ois.readObject(); //Object is stored in the file. After this point file pointer goes to the next byte.
                    if (oldEntityData.getEntity().getName().equals(newEntityData.getEntity().getName())
                            && oldEntityData.getDeleted() == 0
                            && oldEntityData.getRecord().get(0).equals(newEntityData.getRecord().get(0))) {
                        dbFile.seek(filePointer);//Refers to the previous EntityData object.
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ObjectOutputStream ooso = new ObjectOutputStream(baos);
                        oldEntityData.setDeleted(1);
                        ooso.writeObject(oldEntityData);
                        ooso.flush();
                        dbFile.write(baos.toByteArray());
                        baos.close();
                        break;
                    }
                }
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream ooso = new ObjectOutputStream(baos);
                ooso.writeObject(newEntityData);
                ooso.flush();
                dbFile.seek(dbFile.length()); //Go at the end of file.
                dbFile.write(baos.toByteArray()); //Add entity data in byte form to the end of file.
                baos.close();
                ooso.close();
            } else if (insertUpdateDeleteMode == 3) { //Is used when the user clicks on "delete" jbuttonPanel to delete a record.
                System.out.println("DELETING");
                EntityData existingEntity = new EntityData(entity, today, record, 1);
                while (dbFile.getFilePointer() != dbFile.length()) {
                    long filePointer = dbFile.getFilePointer();
                    dbFile.seek(dbFile.getFilePointer());
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dbFile.getFD()));
                    EntityData oldEntityData = (EntityData) ois.readObject(); //after this point file pointer goes to the next byte.
                    if (oldEntityData.getEntity().getName().equals(existingEntity.getEntity().getName())
                            && oldEntityData.getDeleted() == 0
                            && oldEntityData.getRecord().get(0).equals(existingEntity.getRecord().get(0))) { //the zero reffers to the first attribute.
                        dbFile.seek(filePointer);                                                            //We assume that the first attribute is usually the primary key of an Entity.
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ObjectOutputStream ooso = new ObjectOutputStream(baos);
                        oldEntityData.setDeleted(1);
                        ooso.writeObject(oldEntityData);
                        ooso.flush();
                        dbFile.write(baos.toByteArray());
                        baos.close();
                        break;
                    }
                }
            }
            dbFile.close();
            answer = true;
        } catch (FileNotFoundException ex) {
            System.out.println("FILE NOT FOUND EXCEPTION");
            ex.printStackTrace();
            answer = false;
        } catch (IOException ex) {
            System.out.println("IO EXCEPTION");
            ex.printStackTrace();
            answer = false;
        } catch (ClassNotFoundException ex) {
            System.out.println("CLASS NOT FOUND EXCEPTION");
            ex.printStackTrace();
            answer = false;
        }
        return answer;
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
