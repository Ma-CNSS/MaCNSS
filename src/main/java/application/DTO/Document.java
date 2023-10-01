package application.DTO;

import java.net.URL;
import java.util.Date;

public class Document {
    private int Code;
    private double Price;
    private URL URL;
    private DocType DocType;
    private Case casee;
    private Date CreatedAt;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        this.Code = code;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public java.net.URL getURL() {
        return URL;
    }

    public void setURL(java.net.URL URL) {
        this.URL = URL;
    }

    public DocType getDocType() {
        return DocType;
    }

    public void setDocType(DocType docType) {
        this.DocType = docType;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public Case getCasee() {
        return casee;
    }

    public void setCasee(Case casee) {
        this.casee = casee;
    }

    public void setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
    }
}
