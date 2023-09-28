package application.DTO;

public class MedicineInstance {
    private Case casee;
    private Medicine medicine;

    public MedicineInstance(Case casee, Medicine medicine) {
        this.casee = casee;
        this.medicine = medicine;
    }

    public Case getCasee() {
        return casee;
    }

    public void setCasee(Case casee) {
        this.casee = casee;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }


}
