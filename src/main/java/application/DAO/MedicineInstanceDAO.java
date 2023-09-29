package application.DAO;

import application.Config.DBUtility;
import application.Config.Datasource;
import application.DTO.MedicineInstance;
import application.Interfaces.CRUD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MedicineInstanceDAO implements CRUD<MedicineInstance> {
    private final Connection connection = DBUtility.getInstance();

    @Override
    public MedicineInstance get(MedicineInstance medicineInstance) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<MedicineInstance> q = new BeanHandler<>(MedicineInstance.class);
            return run.query("SELECT * FROM medicineinstance  WHERE casee = ? AND medicine = ?", q, medicineInstance.getCasee().getId(), medicineInstance.getMedicine().getCode());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<MedicineInstance> getAll() {
        return null;
    }


    public List<MedicineInstance> getByCase(MedicineInstance medicineInstance) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<List<MedicineInstance>> q = new BeanListHandler<>(MedicineInstance.class);
            return run.query("SELECT * FROM medicineinstance WHERE casee = ?", q, medicineInstance.getCasee().getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean add(MedicineInstance medicineInstance) {
        int numRowsInserted = 0;
        try {
            QueryRunner runner = new QueryRunner();
            String insertSQL = "INSERT INTO medicineinstance (casee, medicine) VALUES (?,?)";
            numRowsInserted = runner.update(connection, insertSQL, medicineInstance.getCasee().getId(), medicineInstance.getMedicine().getCode());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRowsInserted > 0;
    }

    @Override
    public Boolean update(MedicineInstance medicineInstance) {
        return null;
    }

    @Override
    public Boolean delete(MedicineInstance medicineInstance) {
        int numRowsDeleted = 0;
        try {
            QueryRunner runner = new QueryRunner();
            String deleteSQL = "DELETE FROM medicineinstance WHERE medicine = ? AND casee = ?";
            numRowsDeleted = runner.update(connection, deleteSQL, medicineInstance.getMedicine().getCode(), medicineInstance.getCasee().getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRowsDeleted > 0;
    }
}
