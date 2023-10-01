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
    public static boolean execute(Case casee) {
        CaseDAO caseDAO = new CaseDAO();
        MedicineInstanceDAO medicineInstanceDAO = new MedicineInstanceDAO();
        DocumentDAO documentDAO = new DocumentDAO();

        if (caseDAO.add(casee)) {
                MedicineInstance medicineInstance = new MedicineInstance(casee);
            for (Medicine m : casee.getMedicines()) {
                medicineInstance.setMedicine(m);
                if (!medicineInstanceDAO.add(medicineInstance)) {
                    return false;
                }
            }

            for (Document d : casee.getDocuments()) {
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
