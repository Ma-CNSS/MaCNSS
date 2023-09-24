package application.DAO;

import application.Config.DBUtility;
import application.Config.Datasource;
import application.DTO.Agent;
import application.Interfaces.CRUD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AgentDAO extends UserDAO implements CRUD<Agent> {
    private final Connection connection = DBUtility.getInstance();
    @Override
    public Boolean login(Object agent) {
        return null;
    }

    @Override
    public Boolean logout(Object agent) {
        return null;
    }


    @Override
    public Agent get(Agent agent) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<Agent> q = new BeanHandler(Agent.class);
            return (Agent) run.query("SELECT * FROM agents WHERE id = ?", q, agent.getId());
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
    public Boolean add(Agent agent){
        int result = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO agents (firstName, lastName, email, password) VALUES (?,?,?,?)");
            stmt.setString(1, agent.getFirstName());
            stmt.setString(2, agent.getLastName());
            stmt.setString(3, agent.getEmail());
            stmt.setString(4, agent.getPassword());
            result = stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return result > 0;
    }

    @Override
    public Boolean update(Agent agent) {
        return null;
    }

    @Override
    public Boolean delete(Agent agent) {
        return null;
    }
}
