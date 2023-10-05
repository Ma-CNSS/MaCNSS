//package application.DAO2.DAO;
//
//import application.Config.DBUtility;
//import application.Config.Datasource;
//import application.DTO.Case;
//import application.DTO.Document;
//import application.DTO.Medicine;
//import application.DTO.Patient;
//import application.ENUMS.CaseStatus;
//import application.ENUMS.CaseType;
//import application.Interfaces.CRUD;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.ResultSetHandler;
//import org.apache.commons.dbutils.handlers.BeanHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CaseDAO implements CRUD<Case> {
//    private final Connection connection = DBUtility.getInstance();
//
//
//    @Override
//    public Case get(Case casee) {
//        try {
//            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
//            ResultSetHandler<Case> q = new BeanHandler<>(Case.class);
//            return run.query("SELECT * FROM cases WHERE id = ? OR patient = ?", q, casee.getId(), casee.getPatient().getCIN());
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    @Override
//    public List<Case> getAll() {
//        PatientDAO patientDAO = new PatientDAO();
//        Patient patient = new Patient();
//        try {
//            String query = "SELECT * FROM cases";
//            PreparedStatement stmt = connection.prepareStatement(query);
//            ResultSet resultSet = stmt.executeQuery();
//            List<Case> cases = new ArrayList<>();
//            while (resultSet.next()){
//                Case casee = new Case();
//                casee.setId(resultSet.getInt("id"));
//                casee.setPrice(resultSet.getInt("price"));
//                casee.setType(CaseType.valueOf(resultSet.getString("type")));
//                casee.setStatus(CaseStatus.valueOf(resultSet.getString("status")));
//                patient.setCIN(resultSet.getString("patient"));
//                casee.setPatient(patientDAO.get(patient));
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public List<Case> getAllByPatient(Case casee) {
//        try {
//            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
//            ResultSetHandler<List<Case>> q = new BeanListHandler<>(Case.class);
//            return run.query("SELECT * FROM cases WHERE patient = ?", q, casee.getPatient().getCIN());
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    @Override
//    public Boolean add(Case casee) {
//        try {
//            QueryRunner runner = new QueryRunner();
//            String insertSQL = "INSERT INTO cases (id, price, type, status, patient) VALUES (?,?,?,?,?)";
//            int numRowsInserted = runner.update(connection, insertSQL, casee.getId(), casee.getPrice(), casee.getType(), casee.getStatus(), casee.getPatient().getCIN());
//            return numRowsInserted > 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
//
//    @Override
//    public Boolean update(Case casee) {
//        int numRowsUpdated = 0;
//        try {
//            QueryRunner runner = new QueryRunner();
//            String updateSQL = "UPDATE cases SET price = ?, type = ?, status = ?, patient = ? WHERE id = ?";
//            numRowsUpdated = runner.update(connection, updateSQL, casee.getPrice(), casee.getType(), casee.getStatus(), casee.getPatient().getCIN(), casee.getId());
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return numRowsUpdated > 3;
//    }
//
//    @Override
//    public Boolean delete(Case casee) {
//        try {
//            QueryRunner runner = new QueryRunner();
//            String deleteSQL = "DELETE FROM cases WHERE id = ?";
//            int numRowsDeleted = runner.update(connection, deleteSQL, casee.getId());
//            return numRowsDeleted > 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//    public Case processCase(Case casee){
//        double sumDocuments = 0;
//        double sumMedicines = 0;
////        casee.getDocuments()
//        for(Document document: casee.getDocuments()){
//            sumDocuments += document.getPrice();
//        }
//        for(Medicine medicine: casee.getMedicines()){
//            sumMedicines += medicine.getPrice();
//        }
//        casee.setPrice(sumDocuments + sumMedicines);
//        return casee;
//    }
//}
