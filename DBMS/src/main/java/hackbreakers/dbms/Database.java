package hackbreakers.dbms;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.Scanner;

public class Database {

    private String name;
    private List<Entity> entities;
    private RandomAccessFile dbmsFile;//θέλω να σώζω σε ξεχωριστό αρχείο τα entitites του database. Είναι τα system files, εκεί που έχω τις περιγραφές των δεδομένων, αποθηκεύω τα objects των entities
    private RandomAccessFile databaseFile;//θέλω να σώζω σε ξεχωριστό αρχείο τα δεδομένα των entities. Εδώ αποθηκεύονται τα data που αντιστοιχίζονται στα attributes.

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

    public void databaseMenu() throws IOException, ClassNotFoundException {// Καλεί το κεντρικό menu
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to my DATABASE Program");
            System.out.println("----------Main Menu-----------");
            System.out.println("     1. Create Database");
            System.out.println("     2. Explore Database");
            System.out.println("     3. Modify Database");
            System.out.println("     4. Delete Database");
            System.out.println("     5. Exit");
            System.out.println("------------------------------");
            System.out.print("Make a selection (1-5): ");

            boolean isSelection = sc.hasNextInt(); // Is it number or letter?

            if (isSelection) {
                answer = sc.nextInt();
                switch (answer) {
                    case 1:
                        System.out.println("Navigating to Database creation...");//1. Create database
                        createDatabase();//Δημιοιυργεί ένα folder με το όνομα της database που θέλω να φτιάξω και φτιάχνει και 2 αρχεία
                        createEntities();
                        break;
                    case 2:
                        System.out.println("Navigating to exploring a Database...");//2. Επιλέγει τη βάση δεδομένων και κάνει show(βλέπει τα entities και τα δεδομένα τους
                        exploreDatabase();
                        break;
                    case 3:
                        System.out.println("Navigating to modifying a Database...");//3. Τροποιποίηση database
                        modifyDatabase();
                        createEntities();
                        break;
                    case 4:
                        System.out.println("Navigating to deleting a Database...");//Delete Database
                        deleteDatabase();
                        break;
                    case 5:
                        System.out.println("Exiting...");//Κλείνει το πρόγραμμα
                        System.exit(0);
                    default:
                        System.out.println("That was not a number between 1 and 5! Try again!");
                        break;
                }
            } else {
                sc.next();
                System.out.println("That was not a number! Try Again");// Έλεγχος για το αν ο χρήστης βάζει αριθμό ή κάτι άλλο.
            }
        }
    }
}
