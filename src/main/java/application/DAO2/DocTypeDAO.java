package application.DAO2;

import application.Config.DBUtility;
import application.Config.Datasource;
import application.DTO.DocType;
import application.Interfaces.CRUD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DocTypeDAO implements CRUD<DocType> {
    private final Connection connection = DBUtility.getInstance();

    @Override
    public DocType get(DocType docType) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<DocType> q = new BeanHandler<>(DocType.class);
            return run.query("SELECT * FROM doctypes WHERE id = ? OR name = ?", q, docType.getId(), docType.getName());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<DocType> getAll() {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<List<DocType>> q = new BeanListHandler<>(DocType.class);
            return run.query("SELECT * FROM doctypes", q);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean add(DocType docType) {
        try {
            QueryRunner runner = new QueryRunner();
            String insertSQL = "INSERT INTO docTypes (name, refundRate) VALUES (?,?)";
            int numRowsInserted = runner.update(connection, insertSQL, docType.getName(), docType.getRefundRate());
            return numRowsInserted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(DocType docType) {
        int numRowsUpdated = 0;
        try {
            QueryRunner runner = new QueryRunner();
            String updateSQL = "UPDATE doctypes SET name = ?, refundrate = ? WHERE id = ?";
            numRowsUpdated = runner.update(connection, updateSQL, docType.getName(), docType.getRefundRate(), docType.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRowsUpdated > 3;
    }

    @Override
    public Boolean delete(DocType docType) {
        try {
            QueryRunner runner = new QueryRunner();
            String deleteSQL = "DELETE FROM doctypes WHERE id = ?";
            int numRowsDeleted = runner.update(connection, deleteSQL, docType.getId());
            return numRowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
