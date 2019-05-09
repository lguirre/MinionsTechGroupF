
import java.util.Scanner;
import java.lang.NullPointerException;

public class Operation {
    public void select() {
        ContactsManager myContactManager = new ContactsManager();

        int i = 0;
        do {
            Menu mymenu = new Menu();
            int option = mymenu.showmenu();
            if (option == 1) {

                Scanner keyboard = new Scanner(System.in);
                System.out.println("Input the name");
                String inputname = keyboard.next();
                Contact var = new Contact();
                if (inputname != null && !inputname.isEmpty()){

                    var.name = inputname;

                }else{
                    System.out.println("Please input a name is mandatory");
                    inputname = keyboard.next();
                    var.name = inputname;
                }


                System.out.println("Input the Phone Number");
                String phoneNumber = keyboard.next();
                var.phoneNumber = phoneNumber;

                System.out.println("Input the email");
                String eMail = keyboard.next();
                var.email = eMail;
                myContactManager.addContact(var);
            } else if (option == 2) {
                myContactManager.showContact();
            } else if (option == 3) {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Input the name");
                String inputname = keyboard.next();


                try {

                    Contact buscar = myContactManager.searchContact(inputname);
                    System.out.println(buscar.phoneNumber);

                } catch (NullPointerException e) {
                    System.out.println("Contact not found");
                }
            } else if (option == 4) {
                Scanner keyboard = new Scanner(System.in);
                System.out.println("Input the name");
                String inputname = keyboard.next();
                try {
                    myContactManager.deleteContact(inputname);
                }catch (NullPointerException e){
                    System.out.println("Contact not found");
                }
            } else {
                System.out.println("Closing");
                i++;
            }
        }while(i==0);

    }
}
