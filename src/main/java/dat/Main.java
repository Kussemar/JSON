package dat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static void main(String[] args) {
        Person person;
        Account account;
        Address address;

        person = new Person("John", "Doe", "01/01/1970");
        account = new Account("1000", true);
        address = new Address("123 Main St", "Anytown", 12345);


        CustomerDTO customerDTO = new CustomerDTO(person, account, address);
        String json = gson.toJson(customerDTO);
        System.out.println(json);

        CustomerDTO cDto = gson.fromJson(json, CustomerDTO.class);
        System.out.println(cDto);
    }
}