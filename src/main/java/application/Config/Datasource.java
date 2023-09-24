package application.Config;

import javax.sql.DataSource;
//import com.mysql.cj.jdbc.MysqlDataSource;
//import javax.sql.DataSource;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
import org.postgresql.ds.PGSimpleDataSource;
import javax.sql.DataSource;


public class Datasource {

    public static DataSource getPostgreSQLDataSource() {
        PGSimpleDataSource pgDS = new PGSimpleDataSource();
        pgDS.setURL(DBUtility.url);
        pgDS.setUser(DBUtility.username);
        pgDS.setPassword(DBUtility.password);
        return pgDS;
    }
    public static DataSource getMySQLDataSource() {
//        MysqlDataSource mysqlDS = null;
//        mysqlDS = new MysqlDataSource();
//        mysqlDS.setURL(MySQL.url);
//        mysqlDS.setUser(MySQL.username);
//        mysqlDS.setPassword(MySQL.password);
//        return mysqlDS;
        return null;
    }

    public static DataSource getOracleDataSource(){
//        OracleDataSource oracleDS = null;
//        try {
//            oracleDS = new OracleDataSource();
//            oracleDS.setURL(props.getProperty("ORACLE_DB_URL"));
//            oracleDS.setUser(props.getProperty("ORACLE_DB_USERNAME"));
//            oracleDS.setPassword(props.getProperty("ORACLE_DB_PASSWORD"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return oracleDS;
        return null;
    }

}
