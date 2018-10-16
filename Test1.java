
import java.util.*;

public class Test1 {

    public static void main(String[] args) {
        ArrayList<ArrayList> basic = new ArrayList<ArrayList>();
        ArrayList<String> fields = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);

            System.out.println("Welcome to your Database!\n Let's start by giving it a name.Don't think about is so much :)");
            String nameofdata = sc.next();
            System.out.println("Great! " + nameofdata + " has been created!\n Now let's build your first field.Please give us its name.");
            String nameoffield = sc.next();
            fields.add(nameoffield);
            basic.add(new ArrayList<String>());
            System.out.println("Field " + nameoffield + " has been succesfully created!");
            System.out.println("Do you want to add another field?Please answer with YES or NO");
            String apantisi = sc.next();
            apantisi = checkYesOrNo(apantisi);
            while (apantisi.equals("YES")) {
                System.out.println("Give us its name");
                nameoffield = sc.next();
                fields.add(nameoffield);
                basic.add(new ArrayList<String>());
                System.out.println("Field " + nameoffield + " has been succesfully created!");
                System.out.println("number of fields is :" + basic.size());
                System.out.println("Do you want to add another field?Please answer with YES or NO");
                apantisi = sc.next();
                apantisi = checkYesOrNo(apantisi);
            }
     int ans = callMenu();
     while (ans!=7) {
         if (ans==1) {
             apantisi = "YES";
             while (apantisi.equals("YES")) {
                System.out.println("Give us its name");
                nameoffield = sc.next();
                fields.add(nameoffield);
                basic.add(new ArrayList<String>());
                System.out.println("Field " + nameoffield + " has been succesfully created!");
                System.out.println("Do you want to add another field?Please answer with YES or NO");
                apantisi = sc.next();
                apantisi = checkYesOrNo(apantisi);
            }
            ans = callMenu();
        }
        else if (ans==2) {
            for (int i=0 ; i<basic.size() ; i++) {
                System.out.println("Give us the " + fields.get(i));
                String name = sc.next();
                basic.get(i).add(name);
            }
              ans = callMenu();
        }
        else if (ans==3) {
            if (basic.get(0).size()==0) {
                System.out.println("There are no elements!\n");
                ans = callMenu();
            }
            else if (basic.get(0).size()!=0) {
            for (int j=0 ; j<basic.get(0).size() ; j++ ) {
            for (int i=0 ; i<basic.size() ; i++) {
                if (basic.get(i).get(j)!=null) {
              System.out.print("" + fields.get(i) + ": " + basic.get(i).get(j) + "  ");
                }
            }
            System.out.println();
            }
            ans = callMenu();
        }
        }
        else if (ans==4) {
            if (basic.get(0).size()==0) {
                System.out.println("There are no elements!\n");
                ans = callMenu();
            }
            else if (basic.get(0).size()!=0) {
            System.out.print("Give the " + fields.get(0));
           for (int i=1 ; i<basic.size() ; i++) {
               System.out.print(" or the " + fields.get(i));
           }
           System.out.println(" of the element you want to delete");
           String deletable = sc.next();
           int i = 0;
           int j;
           boolean flag = false;
           while (i<basic.size() && flag == false) {
               j=0;
               while (j<basic.get(i).size() && flag == false) {
                   if (deletable.equals(basic.get(i).get(j))) {
                       flag = true;
                       for (int k=0 ; k<basic.size() ; k++) {
                       basic.get(k).remove(j);
                   }
                   }
                   j++;
               }
              i++;
           }

           if (flag == false) {
               System.out.println("The element does not exist!");
               ans = callMenu();
           }
           ans = callMenu();
        }
        }
        else if (ans==5) {
            if (basic.get(0).size()==0) {
                System.out.println("There are no elements!");
                ans = callMenu();
            }
            else if (basic.get(0).size()!=0) {
            System.out.print("Give the " + fields.get(0));
           for (int i=1 ; i<basic.size() ; i++) {
               System.out.print(" or the " + fields.get(i));
           }
           System.out.println(" of the element you want to change");
           String changable = sc.next();
           int i = 0;
           int j;
           boolean flag = false;
           while (i<basic.size() && flag == false) {
               j=0;
               while (j<basic.get(i).size() && flag == false) {
                   if (changable.equals(basic.get(i).get(j))) {
                       flag = true;
                       for (int k=0 ; k<basic.size() ; k++) {
                        System.out.println("Give us the new " + fields.get(k));
                        String name = sc.next();
                        basic.get(k).set(j,name);
                   }
                   }
                   j++;
               }
              i++;
           }

           if (flag == false) {
               System.out.println("The element does not exist!");
               ans = callMenu();
           }
           ans = callMenu();
        }
        }
        else if (ans==6) {
            for (int i=0 ; i<basic.size() ; i++) {
                basic.get(i).clear();
            }
             ans = callMenu();
        }

        }
    }



    public static String checkYesOrNo(String apantisi) {
        Scanner sc = new Scanner(System.in);
        if (apantisi.equals("YES")) {
            return apantisi;
        }
        else if (apantisi.equals("NO")) {
            return apantisi;
        }
        else {
            System.out.println("Please answer only with YES or NO");
            String apantisi2 = sc.next();
            apantisi = checkYesOrNo(apantisi2);
            return apantisi;
        }

    }

    public static int callMenu() {
     Scanner sc = new Scanner(System.in);
     Menu item = new Menu();
     System.out.println(item.showMenu());
     int ans = sc.nextInt();
     int loco = item.checkAnswer(ans);
     while (loco==0) {
         System.out.println("Please enter one of the numbers among 1-7\n");
         System.out.println(item.showMenu());
         ans = sc.nextInt();
         loco = item.checkAnswer(ans);
    }
     return ans;


    }
}
