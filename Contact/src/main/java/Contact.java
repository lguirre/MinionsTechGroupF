/**
 * Entity Contact.
 */
public class Contact {

    private String name;
    private String email;
    private String phoneNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean contains(String key) {
        return name.contains(key)
            || email.contains(key)
            || phoneNumber.contains(key);
    }

    @Override
    public String toString() {
        return String
            .format("Name: '%s', Email: '%s', Phone Number: '%s' ", name, email, phoneNumber);
    }
}
