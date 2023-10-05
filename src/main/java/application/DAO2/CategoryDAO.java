package application.DAO2;

import application.Config.DBUtility;
import application.Config.Datasource;
import application.DTO.Category;
import application.Interfaces.CRUD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDAO implements CRUD<Category> {
    private final Connection connection = DBUtility.getInstance();
    @Override
    public Category get(Category category) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<Category> q = new BeanHandler<>(Category.class);
            return run.query("SELECT * FROM categories WHERE id = ? OR name = ?", q, category.getId(), category.getName());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Category> getAll() {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<List<Category>> q = new BeanListHandler<>(Category.class);
            return run.query("SELECT * FROM categories", q);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean add(Category category) {
        try {
            QueryRunner runner = new QueryRunner();
            String insertSQL = "INSERT INTO categories (name) VALUES (?)";
            int numRowsInserted = runner.update(connection, insertSQL, category.getName());
            return numRowsInserted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Category category) {
        int numRowsUpdated = 0;
        try {
            QueryRunner runner = new QueryRunner();
            String updateSQL = "UPDATE categories SET name = ? WHERE id = ?";
            numRowsUpdated = runner.update(connection, updateSQL, category.getName(), category.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRowsUpdated > 3;
    }

    @Override
    public Boolean delete(Category category) {
        try {
            QueryRunner runner = new QueryRunner();
            String deleteSQL = "DELETE FROM categories WHERE id = ?";
            int numRowsDeleted = runner.update(connection, deleteSQL, category.getId());
            return numRowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
