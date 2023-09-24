package application.DTO;

public class DocType {
    private int Id;
    private String Name;
    private double RefundRate;

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

    public double getRefundRate() {
        return RefundRate;
    }

    public void setRefundRate(double refundRate) {
        this.RefundRate = refundRate;
    }
}
