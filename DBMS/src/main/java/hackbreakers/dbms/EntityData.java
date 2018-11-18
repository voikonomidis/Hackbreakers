package hackbreakers.dbms;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntityData implements Serializable{//Δίνουμε τη δυνατότητα στο χρήστη να κάνει mapping των δεδομένων στα αντίστοιχα entities(και των attributes τους)

    private Entity entity;//Με τη μεταβλτητή γίνεται αντιστοίχηση μιας οντότητας με τα records.
    private LocalDate dateOfCreation;//πότε δημιουργήθηκε το κάθε record
    private List<Object> record = new ArrayList();// Λίστα τύπου object. Παίρνει τις εγγραφές των δεδομένων που θα περαστούν στο database. Σώζονται σαν objects στο random access file

}