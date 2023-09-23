package application.DTO;

public class Admin extends User {
    public Admin(){}
    public Admin(String firstName, String lastName, String email, String password){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }

}
