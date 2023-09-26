package application.DTO;

public class Agent extends User {
    public Agent(){}
    public Agent(String email, String password){
        setEmail(email);
        setPassword(password);
    }
}
