import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		ContactManager myContactManager = new ContactManager();
		Contact friendOne;
		Scanner input = new Scanner(System.in);
		String name;
		String email;
		String phoneNumber;
		while(true){
			System.out.println("------------ M E N U ------------");
			
			System.out.println("1 = Add Contact\n"
					+ "2 = Show Contacts\n"
					+ "3 = Search Contact\n"
					+ "4 = Delete Contact\n"
					+ "5 = Exit");
			try{
				System.out.println("------------ Insert option: ------------");
				int option = input.nextInt();
				switch(option){
					case 1:
						System.out.println("Insert Name");
						name = input.next();
						
						System.out.println("Insert email");
						email = input.next();
						
						System.out.println("Insert Phone Number");
						phoneNumber = input.next();
						
						friendOne = new Contact(name, email, phoneNumber);
						myContactManager.addContact(friendOne);
						
						break;
					case 2:
						System.out.println("------------ Contacts: ------------");
						myContactManager.showContacts();
						break;
						
					case 3:
						System.out.println("------------ Search Contacts ------------");
						System.out.println("insert word");
						name = input.next();
						myContactManager.searchContact(name);
						break;
						
					case 4:
						System.out.println("------------ delete Contact ------------");
						System.out.println("insert contact name");
						name = input.next();
						myContactManager.deleteContact(name);					
						break;
					
					case 5:
						System.exit(0);
						break;
				}	
			}
			catch(Exception e){
				e.getMessage();
			}
		}
	}
}
