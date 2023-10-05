package application.DTO2;

import java.util.HashMap;
import java.util.Map;

public class Admin extends Staff {
    private Integer Id;
    public Admin(){}
    public Admin(String email, String password){
        setEmail(email);
        setPassword(password);
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Map<String, Object> getAdmin() {
        Map<String, Object> adminData = new HashMap<>();
        if (this.CIN != null) adminData.put("CIN", this.CIN);
        if (this.First_name != null) adminData.put("First_name", this.First_name);
        if (this.Last_name != null) adminData.put("Last_name", this.Last_name);
        if (this.Birthday != null) adminData.put("Birthday", this.Birthday);
        if (this.Email != null) adminData.put("Email", this.Email);
        if (this.Phone != null) adminData.put("Phone", this.Phone);
        if (this.Password != null) adminData.put("Password", this.Password);
        return adminData;
    }
}
