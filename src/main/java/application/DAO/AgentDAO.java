package application.DAO;

import application.Config.DBUtility;
import application.DTO.Agent;
import application.Interfaces.CRUD;
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
        return null;
    }

    @Override
    public List<Agent> getAll(Agent agent) {
        return null;
    }

    @Override
    public Boolean add(Agent agent){
        int result = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO agents (first_name, last_name, email, password) VALUES (?,?,?,?)");
            stmt.setString(1, agent.getFirstName());
            stmt.setString(2, agent.getLastName());
            stmt.setString(3, agent.getEmail());
            stmt.setString(4, agent.getPassword());
            result = stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return result > 1;
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
