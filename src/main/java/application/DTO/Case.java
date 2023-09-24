package application.DTO;

import application.ENUMS.*;

import java.util.Date;
import java.util.List;

public class Case {
    private int Id;
    private double Price;
    private Type Type;
    private Status Status;
    private Patient Patient;
    private List<Document> documents;
    private List<Medicine> medicines;
    private Date SubmissionDate;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type type) {
        this.Type = type;
    }

    public Status getStatus() {
        return Status;
    }

    public void setStatus(Status status) {
        this.Status = status;
    }

    public Patient getPatient() {
        return Patient;
    }

    public void setPatient(Patient patient) {
        this.Patient = patient;
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

    public Date getSubmissionDate() {
        return SubmissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
        SubmissionDate = submissionDate;
    }
}
