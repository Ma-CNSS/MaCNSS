package application.DAO;

import application.Config.DBUtility;
import application.Config.Datasource;
import application.Config.SessionManager;
import application.DTO.Agent;
import application.Helpers.PasswordGenerator;
import application.Interfaces.CRUD;
import application.Services.EmailService;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class AgentDAO extends UserDAO<Agent> implements CRUD<Agent> {

    public static String username;
    public static String password;

    static {
        ResourceBundle rd = ResourceBundle.getBundle("mailing");
        username = rd.getString("mail.username");
        password = rd.getString("mail.password");
    }

    private final Connection connection = DBUtility.getInstance();
    public String emailMessage = "Hello dear agent, here is your one time password: \nThis password expires in 10 minutes: ";
    public String subject = "Verification mail";
//    private Map<String, Object> session = SessionManager.getInstance();

    @Override
    public Boolean login(Agent agent) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<Agent> q = new BeanHandler<>(Agent.class);
            String sql = "SELECT * FROM agents WHERE email = ?";
            Agent a = run.query(sql, q, agent.getEmail());
            if (Objects.nonNull(a) && checkPassword(agent.getPassword(), a.getPassword())) {
                int otp = generateRandomCode(6);
                SessionManager.setAttribute(agent.getEmail(), otp, 600000);
                return EmailService.sendMail(emailMessage + otp, subject, agent.getEmail());
            }
            return false;
        } catch (SQLException | RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean logout(Agent object) {
        return null;
    }

    @Override
    public Agent verifyLogin(Agent agent, Integer otp) {
        if (SessionManager.verifyValue(agent.getEmail(), otp))
            return agent;
        return null;
    }

    @Override
    public String generatePassword() {
        return PasswordGenerator.generatePassword(12);
    }

    @Override
    public Agent get(Agent agent) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<Agent> q = new BeanHandler<>(Agent.class);
            return run.query("SELECT * FROM agents WHERE id = ? OR email = ?", q, agent.getId(), agent.getEmail());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Agent> getAll() {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<List<Agent>> q = new BeanListHandler<>(Agent.class);
            return run.query("SELECT * FROM agents", q);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean add(Agent agent) {
        try {
            QueryRunner runner = new QueryRunner();
            String insertSQL = "INSERT INTO agents (firstName, lastName, email, password) VALUES (?,?,?,?)";
            agent.setPassword(generatePassword());
            int numRowsInserted = runner.update(connection, insertSQL, agent.getFirstName(), agent.getLastName(), agent.getEmail(), hashPassword(agent.getPassword()));
            if (numRowsInserted > 0) {
                String body = "Congratulations, Your account has been created.\nKindly use this password to login in to your account: ";
                String subject = "MaCNSS agent Account created";
                return EmailService.sendMail(body + agent.getPassword(), subject, agent.getEmail());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Agent agent) {
        int numRowsUpdated = 0;
        try {
            QueryRunner runner = new QueryRunner();
            String updateSQL
                    = "UPDATE agents SET firstname = ?, lastname = ?, email = ?, password = ? WHERE id = ?";
            numRowsUpdated = runner.update(connection, updateSQL, agent.getFirstName(), agent.getLastName(), agent.getEmail(), agent.getPassword(), agent.getId());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRowsUpdated > 3;
    }

    @Override
    public Boolean delete(Agent agent) {
        try {
            QueryRunner runner = new QueryRunner();
            String deleteSQL = "DELETE FROM agents WHERE id = ?";
            int numRowsDeleted = runner.update(connection, deleteSQL, agent.getId());
            return numRowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
