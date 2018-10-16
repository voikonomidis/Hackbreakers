
public class Menu {
    
    public String showMenu() {
        return "Please select one of the following options:\n\n Press 1 to add another field\n Press 2 to add an element\n "
                + "Press 3 to show the existing elements\n Press 4 to delete an element\n Press 5 to change an element\n"
                + " Press 6 to delete all existing elements\n Press 7 to Exit";
    }
    
    public int checkAnswer(int answer) {
        if (answer==1) {
            return 1;
        }
        else if (answer==2) {
            return 1;
        }
        else if (answer==3) {
            return 1;
        }
        else if (answer==4) {
            return 1;
        }
        else if (answer==5) {
            return 1;
        }
        else if (answer==6) {
            return 1;
        }
        else if (answer==7){
            return 1;
        }
        else {
            return 0;
        }
    }
    
}
