package application.DAO;

import application.Config.DBUtility;
import application.Config.Datasource;
import application.DTO.Case;
import application.DTO.Category;
import application.DTO.Patient;
import application.Interfaces.CRUD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PatientDAO implements CRUD<Patient> {
    private final Connection connection = DBUtility.getInstance();

    @Override
    public Patient get(Patient patient) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<Patient> q = new BeanHandler(Patient.class);
            return (Patient) run.query("SELECT * FROM patients WHERE cin = ? OR name = ?", q, patient.getCIN(), patient.getName());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Patient> getAll() {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<List<Patient>> q = new BeanListHandler<>(Patient.class);
            return run.query("SELECT * FROM patients", q);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean add(Patient patient) {
        try {
            QueryRunner runner = new QueryRunner();
            String insertSQL = "INSERT INTO patients (cin, name, email) VALUES (?,?,?)";
            int numRowsInserted = runner.update(connection, insertSQL,patient.getCIN(), patient.getName(), patient.getEmail());
            return numRowsInserted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Patient patient) {
        int numRowsUpdated = 0;
        try {
            QueryRunner runner = new QueryRunner();
            String updateSQL = "UPDATE patients SET cin = ?, name = ?, email = ? WHERE id = ?";
            numRowsUpdated = runner.update(connection, updateSQL, patient.getCIN(), patient.getName(), patient.getEmail());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRowsUpdated > 3;
    }

    @Override
    public Boolean delete(Patient patient) {
        try {
            QueryRunner runner = new QueryRunner();
            String deleteSQL = "DELETE FROM patients WHERE cin = ?";
            int numRowsDeleted = runner.update(connection, deleteSQL, patient.getCIN());
            return numRowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
