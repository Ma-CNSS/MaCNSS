package application.DAO;

import application.Config.DBUtility;
import application.Config.Datasource;
import application.DTO.Agent;
import application.DTO.Case;
import application.DTO.Category;
import application.Interfaces.CRUD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CaseDAO implements CRUD<Case> {
    private final Connection connection = DBUtility.getInstance();


    @Override
    public Case get(Case casee) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<Case> q = new BeanHandler(Case.class);
            return (Case) run.query("SELECT * FROM cases WHERE id = ? OR patient = ?", q, casee.getId(), casee.getPatient().getCIN());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Case> getAll() {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<List<Case>> q = new BeanListHandler<>(Case.class);
            return run.query("SELECT * FROM cases", q);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Case> getAllByPatient(Case casee) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<List<Case>> q = new BeanListHandler<>(Case.class);
            return run.query("SELECT * FROM cases WHERE patient = ?", q, casee.getPatient().getCIN());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean add(Case casee) {
        try {
            QueryRunner runner = new QueryRunner();
            String insertSQL = "INSERT INTO cases (id, price, type, status, patient) VALUES (?,?,?,?,?)";
            int numRowsInserted = runner.update(connection, insertSQL, casee.getId(), casee.getPrice(), casee.getType(), casee.getStatus(), casee.getPatient().getCIN());
            return numRowsInserted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Case casee) {
        int numRowsUpdated = 0;
        try {
            QueryRunner runner = new QueryRunner();
            String updateSQL = "UPDATE cases SET price = ?, type = ?, status = ?, patient = ? WHERE id = ?";
            numRowsUpdated = runner.update(connection, updateSQL, casee.getPrice(), casee.getType(), casee.getStatus(), casee.getPatient().getCIN(), casee.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRowsUpdated > 3;
    }

    @Override
    public Boolean delete(Case casee) {
        try {
            QueryRunner runner = new QueryRunner();
            String deleteSQL = "DELETE FROM cases WHERE id = ?";
            int numRowsDeleted = runner.update(connection, deleteSQL, casee.getId());
            return numRowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
