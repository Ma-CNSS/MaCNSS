package application.DTO2;

import java.util.Date;

public class Document_type {
    private int Id;
    private String Name;
    private double Refund_rate;
    private Date Created_at;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getRefund_rate() {
        return Refund_rate;
    }

    public void setRefund_rate(double refund_rate) {
        Refund_rate = refund_rate;
    }

    public Date getCreated_at() {
        return Created_at;
    }

    public void setCreated_at(Date created_at) {
        Created_at = created_at;
    }
}
