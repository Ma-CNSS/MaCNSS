package application.DTO2;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Medicine {
    private String Code;
    private String Name;
    private String DC1;
    private BigDecimal Doz;
    private String Doz_unit;
    private String Form;
    private String Presentation;
    private BigDecimal PPV;
    private String PH;
    private BigDecimal Gross_price;
    private String Generic_principles;
    private BigDecimal Reimbursement_rate;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDC1() {
        return DC1;
    }

    public void setDC1(String DC1) {
        this.DC1 = DC1;
    }

    public BigDecimal getDoz() {
        return Doz;
    }

    public void setDoz(BigDecimal doz) {
        Doz = doz;
    }

    public String getDoz_unit() {
        return Doz_unit;
    }

    public void setDoz_unit(String doz_unit) {
        Doz_unit = doz_unit;
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

    public BigDecimal getPPV() {
        return PPV;
    }

    public void setPPV(BigDecimal PPV) {
        this.PPV = PPV;
    }

    public String getPH() {
        return PH;
    }

    public void setPH(String PH) {
        this.PH = PH;
    }

    public BigDecimal getGross_price() {
        return Gross_price;
    }

    public void setGross_price(BigDecimal gross_price) {
        Gross_price = gross_price;
    }

    public String getGeneric_principles() {
        return Generic_principles;
    }

    public void setGeneric_principles(String generic_principles) {
        Generic_principles = generic_principles;
    }

    public BigDecimal getReimbursement_rate() {
        return Reimbursement_rate;
    }

    public void setReimbursement_rate(BigDecimal reimbursement_rate) {
        this.Reimbursement_rate = reimbursement_rate;
    }
    public Map<String, Object> getMedicine(){
        Map<String, Object> medicineData = new HashMap<>();
        if (this.Code != null) medicineData.put("Code", this.Code);
        if (this.Name != null) medicineData.put("Name", this.Name);
        if (this.DC1 != null) medicineData.put("DC1", this.DC1);
        if (this.Doz != null) medicineData.put("Doz", this.Doz);
        if (this.Doz_unit != null) medicineData.put("Doz_unit", this.Doz_unit);
        if (this.Form != null) medicineData.put("Form", this.Form);
        if (this.Presentation != null) medicineData.put("Presentation", this.Presentation);
        if (this.PPV != null) medicineData.put("PPV", this.PPV);
        if (this.PH != null) medicineData.put("PH", this.PH);
        if (this.Gross_price != null) medicineData.put("Gross_price", this.Gross_price);
        if (this.Generic_principles != null) medicineData.put("Generic_principles", this.Generic_principles);
        if (this.Reimbursement_rate != null) medicineData.put("Reimbursement_rate", this.Reimbursement_rate);
        return medicineData;
    }
}
