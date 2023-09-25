package application;

import application.DAO.AdminDAO;
import application.DTO.Admin;
import application.DTO.Agent;

public class Main {
    public static void main(String[] args){

        AdminDAO adminDAO = new AdminDAO();
        Admin admin = new Admin();
        admin.setEmail("mohamed@gmail.com");
        admin.setPassword("Hassan2000");
        if(adminDAO.login(admin))
            System.out.println("true");
        else
            System.out.println("false");
    }

}