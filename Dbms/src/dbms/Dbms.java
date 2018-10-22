package dbms;

import database.Attribute;
import database.Database;
import database.Entity;
import database.RecordsFileException;
import java.io.IOException;
import java.io.OptionalDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bill
 */
public class Dbms {

    public static void main(String[] args) throws IOException, RecordsFileException, OptionalDataException, ClassNotFoundException {
        // TODO code application logic here
        int i = 0;

        //CREATE DATABASE
        Database vassilisdb = new Database("vassilis.db", 64);

        //CREATE ENTITIES AND INSERT
        Entity entity1 = new Entity("Rank", new Attribute("id", "int", (short) 2), new Attribute("title", "String", (short) 100));
        System.out.println(entity1.getEntityName());
        List data = new ArrayList();
        data.add("1,Dievthintis");
        data.add("2,Ypallilos");
        entity1.setData(data);
        for (String str : entity1.getData()) {
            i++;
            vassilisdb.insert(i, str);
        }

        //SELECT ENTITY AND READ
        System.out.println(vassilisdb.select(1));

        //SELECT ENTITY AND UPDATE
        //SELECT ENTITY AND DELETE
        //DELETE DATABASE
    }

}
