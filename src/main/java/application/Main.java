package application;

import application.Config.DBUtility;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con = DBUtility.getInstance();
        System.out.println(con);

    }
}