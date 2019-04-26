import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean runProgram = false;
        ContactsManager myContactManager = new ContactsManager();
        do {
            System.out.println("*********contact manager***************");
            System.out.println("Add contact [A]");
            System.out.println("Show contacts [W]");
            System.out.println("Search contact [S]");
            System.out.println("remove contact  [R]");
            System.out.println("****************************************");
            System.out.println("EXIT  [X]");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input.toLowerCase()) {
                case "x":
                    System.out.println("Exit the program");
                    runProgram = true;
                    break;
                case "a":
                    System.out.println("write name");
                    String name = scanner.nextLine();
                    System.out.println("write phone number");
                    String phone = scanner.nextLine();
                    System.out.println("write email number");
                    String email = scanner.nextLine();
                    if(!name.equals("") && !phone.equals("")){
                        Contact contact = new Contact(name, email, phone);
                        myContactManager.addContact(contact);
                    } else {
                        System.out.println("name and phone is required");
                    }
                    break;
                case "w":
                    System.out.println("you select show contacts");
                    for(Contact friend : myContactManager.myFriends){
                        if (friend != null)
                            System.out.println(friend.name+", "+friend.phoneNumber+", "+ friend.email);
                    }
                    break;
                case "s":
                    System.out.println("you select search contact");
                    System.out.println("write criteria word to search");
                    String wordToSearch = scanner.nextLine();
                    myContactManager.searchContact(wordToSearch);
                    break;
                default:
                    System.out.println("word not exist");
            }

        } while(!runProgram);
    }
}
