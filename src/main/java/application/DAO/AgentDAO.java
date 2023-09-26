package application.DAO;

import application.Config.DBUtility;
import application.Config.Datasource;
import application.Config.SessionManager;
import application.DTO.Agent;
import application.Interfaces.CRUD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class AgentDAO extends UserDAO<Agent> implements CRUD<Agent> {

    public static String username;
    public static String password;
    public String emailMessage = "Hello dear agent, here is your one time password: \nThis password expires in 10 minutes: ";
    public String subject = "Verification mail";

    static {
        ResourceBundle rd = ResourceBundle.getBundle("mailing");
        username = rd.getString("mail.username");
        password = rd.getString("mail.password");
    }

    private final Connection connection = DBUtility.getInstance();
//    private Map<String, Object> session = SessionManager.getInstance();

    public static Boolean sendMail(String body, String subject, String email) {

        Properties properties = System.getProperties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(AgentDAO.username, AgentDAO.password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(AgentDAO.username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject(subject);
            message.setText(body);
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

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
                return AgentDAO.sendMail(emailMessage + otp, subject, agent.getEmail());
            }
            return false;
        } catch (SQLException | RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Agent verifyLogin(Agent agent, int opt){
        if(SessionManager.getValue(agent.getEmail(), opt))
            return agent;
        return null;
    }

    @Override
    public Boolean logout(Agent object) {
        return null;
    }

    @Override
    public Agent verifyLogin(Agent agent, Integer otp) {
        if(SessionManager.getValue(agent.getEmail(), otp))
            return agent;
        return null;
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
            int numRowsInserted = runner.update(connection, insertSQL, agent.getFirstName(), agent.getLastName(), agent.getEmail(), agent.getPassword());
            return numRowsInserted > 0;
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
