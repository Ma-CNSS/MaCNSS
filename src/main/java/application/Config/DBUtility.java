package application.Config;

//import org.apache.commons.dbutils.BasicDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtility {
//    public static String driver;
//    public static String url;
//    public static String username;
//    public static String password;
    private static Connection instance;


//    static {
//        ResourceBundle rd = ResourceBundle.getBundle("db");
//        driver = rd.getString("db.driver");
//        url = rd.getString("db.url");
//        username = rd.getString("db.username");
//        password = rd.getString("db.password");
//    }

    private DBUtility() {

    }

    public static Connection getInstance() {
        if (instance == null)
            instance = new DBUtility().provideConnection();
        return instance;
    }

    private Connection provideConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "sidati", "Akka1998nh");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        return connection;
    }

}