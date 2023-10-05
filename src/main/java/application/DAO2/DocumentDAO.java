//package application.DAO2.DAO;
//
//import application.Config.DBUtility;
//import application.Config.Datasource;
//import application.DTO.Case;
//import application.DTO.DocType;
//import application.DTO.Document;
//import application.Interfaces.CRUD;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.ResultSetHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DocumentDAO implements CRUD<Document> {
//    private final Connection connection = DBUtility.getInstance();
//
//    @Override
//    public Document get(Document document) {
//        try {
//            String query = "SELECT d.code, d.price, d.url, d.createdat, t.id, c.id FROM documents d INNER JOIN public.doctypes t on t.id = d.doctype INNER JOIN public.cases c on c.id = d.casee WHERE code = ?";
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setInt(1, document.getCode());
//            Case casee = new Case();
//            DocType docType = new DocType();
//            ResultSet resultSet = stmt.executeQuery();
//            if (resultSet.next()){
//                document.setCode(resultSet.getInt(1));
//                document.setPrice(resultSet.getDouble(2));
//                document.setURL(resultSet.getURL(3));
//                document.setCreatedAt(resultSet.getDate(4));
//                casee.setId(resultSet.getInt(5));
//                docType.setId(resultSet.getInt(6));
//                document.setDocType(docType);
//                document.setCasee(casee);
//            }
//            return document;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    @Override
//    public List<Document> getAll() {
//        try {
//            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
//            ResultSetHandler<List<Document>> q = new BeanListHandler<>(Document.class);
//            return run.query("SELECT * FROM documents", q);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//    public Case getAllByCase(Case casee) {
//        List<Document> documents = new ArrayList<Document>();
//        try {
//            String query = "SELECT d.code, d.price, d.url, d.createdat, t.id, t.name FROM documents d INNER JOIN public.doctypes t on t.id = d.doctype WHERE d.casee = ?";
//            PreparedStatement stmt = connection.prepareStatement(query);
//            stmt.setInt(1, casee.getId());
//            DocType docType = new DocType();
//            ResultSet resultSet = stmt.executeQuery();
//            Document document = new Document();
//            while (resultSet.next()){
//                document.setCode(resultSet.getInt(1));
//                document.setPrice(resultSet.getDouble(2));
//                document.setURL(resultSet.getURL(3));
//                document.setCreatedAt(resultSet.getDate(4));
//                docType.setId(resultSet.getInt(6));
//                docType.setName(resultSet.getString(7));
//                document.setDocType(docType);
//                document.setCasee(casee);
//                documents.add(document);
//            }
//            casee.setDocuments(documents);
//            return casee;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    @Override
//    public Boolean add(Document document) {
//        try {
//            QueryRunner runner = new QueryRunner();
//            String insertSQL = "INSERT INTO documents (price, doctype, casee, url) VALUES (?,?,?,?)";
//            int numRowsInserted = runner.update(connection, insertSQL, document.getPrice(), document.getDocType().getId(), document.getCasee().getId(), document.getURL());
//            return numRowsInserted > 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
//
//    @Override
//    public Boolean update(Document document) {
//        int numRowsUpdated = 0;
//        try {
//            QueryRunner runner = new QueryRunner();
//            String updateSQL = "UPDATE documents SET price = ?, doctype = ? WHERE code = ?";
//            numRowsUpdated = runner.update(connection, updateSQL, document.getPrice(), document.getDocType().getId(), document.getCode());
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return numRowsUpdated > 3;
//    }
//
//    @Override
//    public Boolean delete(Document document) {
//        try {
//            QueryRunner runner = new QueryRunner();
//            String deleteSQL = "DELETE FROM documents WHERE code = ?";
//            int numRowsDeleted = runner.update(connection, deleteSQL, document.getCode());
//            return numRowsDeleted > 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//}
