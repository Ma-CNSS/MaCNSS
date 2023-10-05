package application.DTO2;

import java.util.HashMap;
import java.util.Map;

public class Agent extends Staff {
    private Integer Id;
    public Agent(){}
    public Agent(String cin, String email, String password){
        setEmail(email);
        setPassword(password);
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
    public Map<String, Object> getAgent() {
        Map<String, Object> agentData = new HashMap<>();
        if (this.CIN != null) agentData.put("CIN", this.CIN);
        if (this.First_name != null) agentData.put("First_name", this.First_name);
        if (this.Last_name != null) agentData.put("Last_name", this.Last_name);
        if (this.Birthday != null) agentData.put("Birthday", this.Birthday);
        if (this.Email != null) agentData.put("Email", this.Email);
        if (this.Phone != null) agentData.put("Phone", this.Phone);
        if (this.Password != null) agentData.put("Password", this.Password);
        return agentData;
    }
}
