public class Contact {
    //Fields
    private String name;
    private String email;
    private String phoneNumber;

    //Constructor
    public Contact(String name, String phoneNumber){
        this(name, phoneNumber, " ");
    }
    public Contact(String name, String phoneNumber, String email){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public String getName(){
        return name;

    }

    public String getPhoneNumber(){
        return phoneNumber;

    }

    public String printContact(){
        return name + " " + phoneNumber + " " + email;
    }
}
