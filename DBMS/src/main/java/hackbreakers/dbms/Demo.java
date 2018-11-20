package hackbreakers.dbms;

import java.io.IOException;

public class Demo {// Runs the program, main menu and its functions.

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Database database = new Database();
        database.databaseMenu();
    }
}
