package application.DAO;

import application.DTO.Admin;
import application.DTO.Agent;

public class AdminDAO extends UserDAO{
    @Override
    public Boolean login(Object object) {
        return null;
    }

    @Override
    public Boolean logout(Object object) {
        return null;
    }
    public Boolean update(Admin admin){
        return true;
    }
}
