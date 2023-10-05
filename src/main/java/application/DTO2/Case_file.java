package application.DTO2;

import java.util.Date;
import java.util.List;

public class Case_file {
    private int Id;
    private application.ENUMS.CaseStatus CaseStatus;
    private application.ENUMS.CaseType CaseType;
    private double Amount;
    private Employee employee;
    private List<Document> documents;
    private List<Medicine> medicines;
    private Date Created_at;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public application.ENUMS.CaseStatus getStatus() {
        return CaseStatus;
    }

    public void setStatus(application.ENUMS.CaseStatus caseStatus) {
        CaseStatus = caseStatus;
    }

    public application.ENUMS.CaseType getType() {
        return CaseType;
    }

    public void setType(application.ENUMS.CaseType caseType) {
        CaseType = caseType;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public Date getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(Date created_at) {
        Created_at = created_at;
    }
}
