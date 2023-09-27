package application.DTO;

public class Admin extends User {
    private static Admin instance;
    public Admin(){}
    public Admin(String email, String password){
//        setFirstName(firstName);
//        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }
    public static Admin getInstance(){
        if (instance == null)
            instance = new Admin();
        return instance;
    }

}
