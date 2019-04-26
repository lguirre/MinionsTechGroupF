package FranzSilva;

/**
 * This class Manage contacts.
 */
public class Contact {

    private String name;
    private String email;
    private String phoneNumber;

    /**
     * Constructor with Name
     *
     * @param name - contact Name.
     */
    public Contact(String name) {
        this.name = name;
        this.email = "";
        this.phoneNumber = "";
    }

    /**
     * Gets name.
     *
     * @return name value.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name value.
     *
     * @param name - Name value.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return - Email value.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets Email.
     *
     * @param email - new Email value.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets Phone.
     *
     * @return Phone number value.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets Phone number.
     *
     * @param phoneNumber - Phone number value.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
