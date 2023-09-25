package application.DAO;

import application.Config.DBUtility;
import application.Config.Datasource;
import application.DTO.Case;
import application.DTO.Category;
import application.DTO.Medicine;
import application.Interfaces.CRUD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MedicineDAO implements CRUD<Medicine> {
    private final Connection connection = DBUtility.getInstance();

    @Override
    public Medicine get(Medicine medicine) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<Medicine> q = new BeanHandler(Medicine.class);
            return (Medicine) run.query("SELECT * FROM medicins  WHERE id = ? OR name = ?", q, medicine.getCode(), medicine.getName());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Medicine> getAll() {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<List<Medicine>> q = new BeanListHandler<>(Medicine.class);
            return run.query("SELECT * FROM medicins", q);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean add(Medicine medicine) {
        try {
            QueryRunner runner = new QueryRunner();
            String insertSQL = "INSERT INTO medicins (name, doz, dozunit, form, presentation, ppv, ph, price, pg, category) VALUES (?,?,?,?,?,?,?,?,?,?)";
            int numRowsInserted = runner.update(connection, insertSQL, medicine.getName(), medicine.getDoz(), medicine.getDozUnit(), medicine.getForm(), medicine.getPresentation(), medicine.getPPV(), medicine.getPH(), medicine.getPrice(), medicine.getPG(), medicine.getCategory().getId());
            return numRowsInserted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Medicine medicine) {
        int numRowsUpdated = 0;
        try {
            QueryRunner runner = new QueryRunner();
            String updateSQL = "UPDATE medicins SET name = ?, doz = ?, dozunit = ?, form = ?, presentation = ?, ppv = ?, ph = ?, price = ?, pg = ?, category = ? WHERE id = ?";
            numRowsUpdated = runner.update(connection, updateSQL, medicine.getName(), medicine.getDoz(), medicine.getDozUnit(), medicine.getForm(), medicine.getPresentation(), medicine.getPPV(), medicine.getPH(), medicine.getPrice(), medicine.getPG(), medicine.getCategory());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRowsUpdated > 3;
    }

    @Override
    public Boolean delete(Medicine medicine) {
        try {
            QueryRunner runner = new QueryRunner();
            String deleteSQL = "DELETE FROM medicins WHERE code = ?";
            int numRowsDeleted = runner.update(connection, deleteSQL, medicine.getCode());
            return numRowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
