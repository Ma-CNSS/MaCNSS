package application.DTO;

public class Medicine {
    private int Code;
    private String Name;
    private String Doz;
    private String DozUnit;
    private String Form;
    private String Presentation;
    private double PPV;
    private double PH;
    private double Price;
    private char PG;
    private Category Category;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDoz() {
        return Doz;
    }

    public void setDoz(String doz) {
        Doz = doz;
    }

    public String getDozUnit() {
        return DozUnit;
    }

    public void setDozUnit(String dozUnit) {
        DozUnit = dozUnit;
    }

    public String getForm() {
        return Form;
    }

    public void setForm(String form) {
        Form = form;
    }

    public String getPresentation() {
        return Presentation;
    }

    public void setPresentation(String presentation) {
        Presentation = presentation;
    }

    public double getPPV() {
        return PPV;
    }

    public void setPPV(double PPV) {
        this.PPV = PPV;
    }

    public double getPH() {
        return PH;
    }

    public void setPH(double PH) {
        this.PH = PH;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public char getPG() {
        return PG;
    }

    public void setPG(char PG) {
        this.PG = PG;
    }

    public Category getCategory() {
        return Category;
    }

    public void setCategory(Category category) {
        this.Category = category;
    }
}
