package application.DTO2;

import java.net.URL;
import java.util.Date;

public class Document {
    private int Code;
    private double Price;
    private URL url;
    private Document_type Document_type;
    private Case_file case_file;
    private Date CreatedAt;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public application.DTO2.Document_type getDocument_type() {
        return Document_type;
    }

    public void setDocument_type(application.DTO2.Document_type document_type) {
        Document_type = document_type;
    }

    public Case_file getCase_file() {
        return case_file;
    }

    public void setCase_file(Case_file case_file) {
        this.case_file = case_file;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }
}
