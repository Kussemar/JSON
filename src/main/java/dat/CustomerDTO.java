package dat;

import lombok.ToString;

@ToString
public class CustomerDTO {
    private String fullname;
    private String city;
    private int zip;
    private boolean isActive;

    public CustomerDTO(String fullname, String city, int zip, boolean isActive) {
        this.fullname = fullname;
        this.city = city;
        this.zip = zip;
        this.isActive = isActive;
    }

    public CustomerDTO(Person person, Account account, Address address){
        this.fullname = person.getFirstname() + " " + person.getLastname();
        this.city = address.getCity();
        this.zip = address.getZip();
        this.isActive = account.isActive();
    }
}
