//package application.Services;
//
//import application.DAO.CaseDAO;
//import application.DAO.DocumentDAO;
//import application.DAO.MedicineDAO;
//import application.DAO.MedicineInstanceDAO;
//import application.DTO.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class GetCase {
//    public static List<Case> getByPatient(Patient patient){
//        CaseDAO caseDAO = new CaseDAO();
//        DocumentDAO documentDAO = new DocumentDAO();
//        MedicineDAO medicineDAO = new MedicineDAO();
//        MedicineInstanceDAO medicineInstanceDAO = new MedicineInstanceDAO();
//        Case casee = new Case();
//        casee.setPatient(patient);
//        List<Case> cases = caseDAO.getAllByPatient(casee);
//        List<Medicine> medicines = new ArrayList<>();
//        for (Case c: cases){
//            documentDAO.getAllByCase(c);
//            MedicineInstance medicineInstance = new MedicineInstance(casee);
//            List<MedicineInstance> medicineInstances = medicineInstanceDAO.getByCase(medicineInstance);
//            for (MedicineInstance m: medicineInstances){
//                medicines.add(medicineDAO.get(m.getMedicine()));
//            }
//        }
//        return cases;
//    }
//    public static List<Case> getAll(){
//        CaseDAO caseDAO = new CaseDAO();
//        DocumentDAO documentDAO = new DocumentDAO();
//        MedicineDAO medicineDAO = new MedicineDAO();
//        MedicineInstanceDAO medicineInstanceDAO = new MedicineInstanceDAO();
//        Case casee = new Case();
//        List<Case> cases = caseDAO.getAll();
//        List<Medicine> medicines = new ArrayList<>();
//        for (Case c: cases){
//            documentDAO.getAllByCase(c);
//            MedicineInstance medicineInstance = new MedicineInstance(casee);
//            List<MedicineInstance> medicineInstances = medicineInstanceDAO.getByCase(medicineInstance);
//            for (MedicineInstance m: medicineInstances){
//                medicines.add(medicineDAO.get(m.getMedicine()));
//            }
//        }
//        return cases;
//    }
//}
