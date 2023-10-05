package application.DAO2;

import application.DTO2.Medicine;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MedicineDAO extends Model2 {
    public MedicineDAO() {
        super("medicines", new String[]{"code"});
    }

    public Optional<Medicine> get(String code) {
        Map<String, Object> medicineData = super.read(new String[]{"code"}, new String[]{code});

        if (medicineData == null) {
            return Optional.empty();
        }

        Medicine medicine = new Medicine();

        medicine.setCode(code);
        medicine.setName( (String) medicineData.get("name"));
        medicine.setDC1( (String) medicineData.get("dc1"));
        medicine.setDoz((BigDecimal) medicineData.get("doz"));
        medicine.setDoz_unit( (String) medicineData.get("doz_unit"));
        medicine.setForm( (String) medicineData.get("form"));
        medicine.setPresentation( (String) medicineData.get("presentation"));
        medicine.setPPV((BigDecimal)medicineData.get("ppv"));
        medicine.setPH( (String) medicineData.get("ph"));
        medicine.setGross_price((BigDecimal)medicineData.get("gross_price"));
        medicine.setGeneric_principles( (String) medicineData.get("generic_principles"));
        medicine.setReimbursement_rate((BigDecimal)medicineData.get("reimbursement_rate"));

        return Optional.of(medicine);
    }

    public List<Medicine> getAll() {
        List<Medicine> medicines = new ArrayList<>();

        List<Map<String, Object>> medicineDataList = super.retrieveAll();

        medicineDataList.forEach((medicineData) -> {
            Medicine medicine = new Medicine();
            System.out.println(medicineData.get("doz"));

            medicine.setCode((String) medicineData.get("code"));
            medicine.setName( (String) medicineData.get("name"));
            medicine.setDC1( (String) medicineData.get("dc1"));
            medicine.setDoz((BigDecimal) medicineData.get("doz"));
            medicine.setDoz_unit( (String) medicineData.get("doz_unit"));
            medicine.setForm( (String) medicineData.get("form"));
            medicine.setPresentation( (String) medicineData.get("presentation"));
            medicine.setPPV((BigDecimal) medicineData.get("ppv"));
            medicine.setPH( (String) medicineData.get("ph"));
            medicine.setGross_price((BigDecimal)medicineData.get("gross_price"));
            medicine.setGeneric_principles( (String) medicineData.get("generic_principles"));
            medicine.setReimbursement_rate((BigDecimal) medicineData.get("reimbursement_rate"));

            medicines.add(medicine);
        });

        return medicines;
    }

    public Optional<Medicine> create(Medicine medicine) throws SQLException {
        if (super.create(medicine.getMedicine()) == null) {
            return Optional.empty();
        } else {
            return Optional.of(medicine);
        }
    }

    public Optional<Medicine> update(Medicine medicine) {
        if (super.update(medicine.getMedicine(), new String[]{medicine.getCode()})) {
            return Optional.of(medicine);
        } else {
            return Optional.empty();
        }
    }

    public boolean delete(Medicine medicine) {
        return super.delete(new String[]{medicine.getCode()});
    }
}