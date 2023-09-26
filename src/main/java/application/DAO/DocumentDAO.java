package application.DAO;

import application.Config.DBUtility;
import application.Config.Datasource;
import application.DTO.Case;
import application.DTO.Category;
import application.DTO.Document;
import application.Interfaces.CRUD;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DocumentDAO implements CRUD<Document> {
    private final Connection connection = DBUtility.getInstance();

    @Override
    public Document get(Document document) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<Document> q = new BeanHandler(Document.class);
            return (Document) run.query("SELECT * FROM documents WHERE code = ? OR doctype = ?", q, document.getCode(), document.getDocType().getName());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Document> getAll() {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<List<Document>> q = new BeanListHandler<>(Document.class);
            return run.query("SELECT * FROM documents", q);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public List<Document> getAllByCase(Case casee) {
        try {
            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
            ResultSetHandler<List<Document>> q = new BeanListHandler<>(Document.class);
            return run.query("SELECT * FROM documents WHERE case ", q);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean add(Document document) {
        try {
            QueryRunner runner = new QueryRunner();
            String insertSQL = "INSERT INTO documents (price, doctype) VALUES (?,?)";
            int numRowsInserted = runner.update(connection, insertSQL, document.getPrice(), document.getDocType().getId());
            return numRowsInserted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Document document) {
        int numRowsUpdated = 0;
        try {
            QueryRunner runner = new QueryRunner();
            String updateSQL = "UPDATE documents SET price = ?, doctype = ? WHERE code = ?";
            numRowsUpdated = runner.update(connection, updateSQL, document.getPrice(), document.getDocType().getId(), document.getCode());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return numRowsUpdated > 3;
    }

    @Override
    public Boolean delete(Document document) {
        try {
            QueryRunner runner = new QueryRunner();
            String deleteSQL = "DELETE FROM documents WHERE code = ?";
            int numRowsDeleted = runner.update(connection, deleteSQL, document.getCode());
            return numRowsDeleted > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
