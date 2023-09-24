package application.DTO;

import java.net.URL;

public class Document {
    private int Code;
    private double Price;
    private URL URL;
    private DocType DocType;

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

    public URL getUrl() {
        return URL;
    }

    public void setUrl(URL url) {
        this.URL = url;
    }

    public DocType getDocType() {
        return DocType;
    }

    public void setDocType(DocType docType) {
        this.DocType = docType;
    }
}
