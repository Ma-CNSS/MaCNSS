package application.Services;

import application.DAO.CaseDAO;
import application.DAO.DocumentDAO;
import application.DAO.MedicineInstanceDAO;
import application.DTO.Case;
import application.DTO.Document;
import application.DTO.Medicine;
import application.DTO.MedicineInstance;

import java.util.List;

public class AddCase {
    public static boolean execute(Case casee, List<Medicine> medicines, List<Document> documents) {
        CaseDAO caseDAO = new CaseDAO();
        MedicineInstanceDAO medicineInstanceDAO = new MedicineInstanceDAO();
        DocumentDAO documentDAO = new DocumentDAO();

        if (caseDAO.add(casee)) {
            for (Medicine m : medicines) {
                MedicineInstance medicineInstance = new MedicineInstance(casee, m);
                if (!medicineInstanceDAO.add(medicineInstance)) {
                    return false;
                }
            }

            for (Document d : documents) {
                d.getCasee().setId(casee.getId());
                if (!documentDAO.add(d)) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

}
