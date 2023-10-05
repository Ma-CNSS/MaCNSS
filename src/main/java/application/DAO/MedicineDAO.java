//package application.DAO;
//
//import application.Config.DBUtility;
//import application.Config.Datasource;
//import application.DTO.Category;
//import application.DTO.Medicine;
//import application.DTO.MedicineInstance;
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
//import java.util.List;
//
//public class MedicineDAO implements CRUD<Medicine> {
//    private final Connection connection = DBUtility.getInstance();
//
//    @Override
//    public Medicine get(Medicine medicine) {
//        ResultSet resultSet = null;
//        try {
////            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
////            ResultSetHandler<Medicine> q = new BeanHandler<>(Medicine.class);
////            return run.query("SELECT m.name, m.doz, m.dozunit, m.form, m.presentation, m.ppv, m.ph, m.price, m.pg, m.category, c.id, c.name FROM medicins m INNER JOIN public.categories c on c.id = m.category WHERE code = ?" , q, medicine.getCode());
//            String query = "SELECT m.name, m.doz, m.dozunit, m.form, m.presentation, m.ppv, m.ph, m.price, m.pg, m.category, c.id, c.name FROM medicins m INNER JOIN public.categories c on c.id = m.category WHERE code = ?";
//            PreparedStatement stmt = connection.prepareStatement(query);
//            Category category = new Category();
//            stmt.setInt(1, medicine.getCode());
//            resultSet = stmt.executeQuery();
//            if (resultSet.next()){
//                medicine.setName(resultSet.getString(2));
//                medicine.setDoz(resultSet.getString(3));
//                medicine.setDozUnit(resultSet.getString(4));
//                medicine.setForm(resultSet.getString(5));
//                medicine.setPresentation(resultSet.getString(6));
//                medicine.setPPV(resultSet.getDouble(7));
//                medicine.setPH(resultSet.getDouble(8));
//                medicine.setPrice(resultSet.getDouble(9));
//                medicine.setPG(resultSet.getString(10));
//                category.setId(resultSet.getInt(11));
//                category.setName(resultSet.getString(12));
//                medicine.setCategory(category);
//            }
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
////    public List<Medicine> get(MedicineInstance me)
//
//    @Override
//    public List<Medicine> getAll() {
//        try {
//            QueryRunner run = new QueryRunner(Datasource.getPostgreSQLDataSource());
//            ResultSetHandler<List<Medicine>> q = new BeanListHandler<>(Medicine.class);
//            return run.query("SELECT * FROM medicins", q);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//
//    @Override
//    public Boolean add(Medicine medicine) {
//        try {
//            QueryRunner runner = new QueryRunner();
//            String insertSQL = "INSERT INTO medicins (name, doz, dozunit, form, presentation, ppv, ph, price, pg, category) VALUES (?,?,?,?,?,?,?,?,?,?)";
//            int numRowsInserted = runner.update(connection, insertSQL, medicine.getName(), medicine.getDoz(), medicine.getDozUnit(), medicine.getForm(), medicine.getPresentation(), medicine.getPPV(), medicine.getPH(), medicine.getPrice(), medicine.getPG(), medicine.getCategory().getId());
//            return numRowsInserted > 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
//
//    @Override
//    public Boolean update(Medicine medicine) {
//        int numRowsUpdated = 0;
//        try {
//            QueryRunner runner = new QueryRunner();
//            String updateSQL = "UPDATE medicins SET name = ?, doz = ?, dozunit = ?, form = ?, presentation = ?, ppv = ?, ph = ?, price = ?, pg = ?, category = ? WHERE code = ?";
//            numRowsUpdated = runner.update(connection, updateSQL, medicine.getName(), medicine.getDoz(), medicine.getDozUnit(), medicine.getForm(), medicine.getPresentation(), medicine.getPPV(), medicine.getPH(), medicine.getPrice(), medicine.getPG(), medicine.getCategory(), medicine.getCode());
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return numRowsUpdated > 3;
//    }
//
//    @Override
//    public Boolean delete(Medicine medicine) {
//        try {
//            QueryRunner runner = new QueryRunner();
//            String deleteSQL = "DELETE FROM medicins WHERE code = ?";
//            int numRowsDeleted = runner.update(connection, deleteSQL, medicine.getCode());
//            return numRowsDeleted > 0;
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return null;
//    }
//}
