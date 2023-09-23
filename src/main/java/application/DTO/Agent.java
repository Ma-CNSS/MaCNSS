package application.DTO;

public class Agent extends User {
    public Agent(){}
    public Agent(String firstName, String lastName, String email, String password){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }
}
