package application.DTO2;

public class Medicine_instance {
    private int Id;
    private Medicine medicine;
    private Case_file case_file;

    public Medicine_instance(Case_file case_file, Medicine medicine) {
        this.case_file = case_file;
        this.medicine = medicine;
    }
    public Medicine_instance(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Case_file getCase_file() {
        return case_file;
    }

    public void setCase_file(Case_file case_file) {
        this.case_file = case_file;
    }
}