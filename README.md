# Hackbreakers - Java Database Management System
|                ΟΔΗΓΙΕΣ ΧΡΗΣΗΣ DBMS-1.0:                 |
|---------------------------------------------------------|              

• Η εφαρμογή μας αποτελεί ένα σύστημα διαχείρισης βάσεων δεδομένων και επιτελεί τις εξής λειτουργίες:
   1. Δημιουργία βάσης/εων δεδομένων.
   2. Δημιουργία οντοτήτων (ορισμός πεδίων).
   3. Εισαγωγή δεδομένων (εγγραφών).
   4. Προβολή οντοτήτων και δεδομένων.
   5. Τροποποίηση δεδομένων.
   6. Διαγραφή δεδομένων.
   7. Διαγραφή βάσης δεδομένων.

* Η εφαρμογή υλοποιείται εξ' ολοκλήρου μέσα από γραφικό περιβάλλον (GUI).
* Όλες οι λειτουργίες περιλαμβάνουν την αποθήκευση των δεδομένων στο δίσκο αλλά και την ανάκτησή τους από αυτόν. 
* Η εφαρμογή μπορεί να δεχτεί τύπους δεδομένων Συμβολοσειρές, Αριθμούς, Ημερομηνίες και λογικές τιμές.

===============================================================================

Εκτέλεση Εφαρμογής:

• Όταν ο χρήστης τρέξει στο αρχείο .jar από την κονσόλα εμφανίζεται το παράθυρο που βλέπετε στην οθόνη.
Πάνω αριστερά φαίνονται οι επιλογές του χρήστη Database με τις υπο-επιλογές Create, Edit, Delete, Exit και About με την υπο-επιλογή Our Team.

• Με το Database>Create εμφανίζεται το επόμενο παράθυρο:
Ο χρήστης συμπληρώνει το όνομα της νέας Βάσης Δεδομένων και με το ποντίκι κάνει κλικ στο ΟΚ. Τότε, εμφανίζεται ένα παράθυρο πληροφόρησης ότι η βάση δημιουργήθηκε επιτυχώς και στο αριστερό μέρος του κεντρικού παραθύρου της εφαρμογής εμφανίζεται το όνομα της βάσης. 

• Κάνοντας κλικ επάνω στο όνομα της βάσης εμφανίζεται το παράθυρο δημιουργίας πινάκων. Ο χρήστης συμπληρώνει το όνομα του πίνακα και με τα κουμπιά + και – προσθέτει ή αφαιρεί αντίστοιχα τα χαρακτηριστικά του πίνακα στον κατάλογο που υπάρχει κάτω από το πεδίο του ονόματος του πίνακα. Ακολούθως κάνει κλικ στο ΟΚ, ένα παράθυρο επιτυχούς δημιουργίας του πίνακα εμφανίζεται και τέλος στο αριστερό μέρος του κεντρικού παραθύρου της εφαρμογής, εμφανίζεται ο πίνακας κάτω από το όνομα της βάσης, υπό μορφή «φύλλου δένδρου».

• Κάνοντας κλικ στον πίνακα, στο δεξί μέρος του κεντρικού παραθύρου της εφαρμογής, εμφανίζονται δύο παράθυρα με δείκτες (tabbed panes): το ένα με ονομασία Table Info και το άλλο με ονομασία Data. Στο Table Info φαίνονται τα χαρακτηριστικά του επιλεγμένου πίνακα, ενώ στο Data τα δεδομένα του. Στο παράθυρο με δείκτη Data ο χρήστης μπορεί να εισάγει, μεταβάλει ή διαγράψει δεδομένα. 

• Κάνοντας κλικ στο New δημιουργείται κενή γραμμή στον κατάλογο ακριβώς επάνω, ο χρήστης τον συμπληρώνει και κάνει κλικ στο Save. Για μεταβολή κάποιας γραμμής δεδομένων το κάνει πάνω στη γραμμή και κάνει κλικ στο Save. Αν θέλει να κάνει διαγραφή κάποιας γραμμής δεδομένων, κάνει κλικ πάνω στην επιθυμητή γραμμή (δηλαδή την επιλέγει) και κάνει κλικ στο Delete.

• Με το Database>Edit εμφανίζεται το επόμενο παράθυρο επιλογής της επιθυμητής βάσης δεδομένων και το κεντρικό παράθυρο της εφαρμογής ενημερώνεται, όπως περιγράφτηκε παραπάνω με το Database>Create.

• Με το Database>Delete εμφανίζεται το επόμενο παράθυρο επιλογής της βάσης που θέλουμε να διαγράψουμε. Κάνοντας κλικ στο ΟΚ και αποδεχόμενος την διαγραφή της βάσης, ο χρήστης διαγράφει το φάκελο της βάσης με τα περιεχόμενα αρχεία του, χωρίς να μπορεί να τα επαναφέρει.

• Με το About>Our Team εμφανίζεται ένα παράθυρο στο οποίο περιγράφονται τα μέλη της ομάδας και οι ευχαριστίες μας.

• Με το Database>Exit κλείνει η εφαρμογή.

===============================================================================

Μερικά τεχνικά στοιχεία:

•* Αυτό που συμβαίνει στο παρασκήνιο είναι ότι δημιουργείται στο path του προγράμματος, ένας φάκελος με το όνομα της βάσης και μέσα στο φάκελο δυο αρχεία πάλι με το όνομα της βάσης, αλλά το ένα με επέκταση .sys και το άλλο με επέκταση .db. Στο .sys αποθηκεύονται υπό μορφή RandomAccessFile οι περιγραφές των πινάκων (DDL), δηλαδή αντικείμενα της κλάσης Entity.java, ενώ στο .db, πάλι υπό μορφή RandomAccessFile τα αντικείμενα της κλάσης EntityData.java στα οποία εμπεριέχονται τα δεδομένα των πινάκων της βάσης.

•* Όταν ο χρήστης δημιουργεί νέο πίνακα, στο αρχείο .sys καταχωρίζεται αντικείμενο τύπου Entity. Όταν ο χρήστης καταχωρίζει δεδομένα στο αρχείο .db της βάσης καταχωρίζονται αντικείμενα τύπου EntityData τα οποία προστίθενται στο τέλος του αρχείου. Όταν ο χρήστης κάνει delete σε δεδομένα, τα αντικείμενα του πίνακα που υπάρχουν στο .db αρχείο, αποκτούν σημαία deleted, αλλά δεν διαγράφονται. Όταν ο χρήστης κάνει μεταβολή των δεδομένων, δημιουργείται στιγμιότυπο του επιλεγμένου προς μεταβολή αντικειμένου EntityData με τα νέα στοιχεία, το παλιό παίρνει σημαία deleted και το νέο καταχωρίζεται στο τέλος του αρχείου .db. 
