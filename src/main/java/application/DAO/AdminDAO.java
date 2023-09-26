package application.DAO;

import application.Config.Datasource;
import application.DTO.Admin;
import application.DTO.Agent;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Objects;

public class AdminDAO extends UserDAO<Admin>{
    @Override
    public Boolean login(Admin admin) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<Admin> q = new BeanHandler(Admin.class);
            String sql = "SELECT * FROM admins WHERE email = ?";
            Admin a = run.query(sql, q, admin.getEmail());
            if (Objects.nonNull(a)){
                admin.setPassword(hashPassword(admin.getPassword()));
                return checkPassword(a.getPassword(), admin.getPassword());
            }else {
                return false;
            }
        } catch (SQLException | RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean logout(Admin admin) {
        return null;
    }
    public Boolean update(Admin admin){
        return true;
    }
}
