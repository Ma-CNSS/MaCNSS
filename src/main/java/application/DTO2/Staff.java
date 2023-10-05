package application.DTO2;

public class Staff extends User {
    protected String CIN;
    protected String First_name;
    protected String Last_name;

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getFirst_name() {
        return First_name;
    }

    public void setFirst_name(String first_name) {
        this.First_name = first_name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String last_name) {
        this.Last_name = last_name;
    }
}
