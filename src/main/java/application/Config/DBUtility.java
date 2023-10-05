package application.Config;

//import org.apache.commons.dbutils.BasicDataSource;
import com.sun.mail.iap.ConnectionException;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtility {
    public static String driver;
    public static String url;
    public static String username;
    public static String password;
    private static Connection instance;

    static {
        ResourceBundle rd = ResourceBundle.getBundle("db");
        driver = rd.getString("db.driver");
        url = rd.getString("db.url");
        username = rd.getString("db.username");
        password = rd.getString("db.password");

    }
    private DBUtility() {}

    public static Connection getInstance() {
        if (instance == null)
            instance = new DBUtility().provideConnection();
        return instance;
    }

    private Connection provideConnection() {
        Connection connection = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return connection;
    }

    public static Connection closeConnection(){
        try {
            instance.close();
            instance = null;
            return null;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return instance;
    }

}