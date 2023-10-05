package application.DTO2;

import application.ENUMS.Month;

public class Salary {
    private Employees_company employeesCompany;
    private Month Work_month;
    private Integer Work_year;
    private Integer Work_day;

    public Employees_company getEmployeesCompany() {
        return employeesCompany;
    }

    public void setEmployeesCompany(Employees_company employeesCompany) {
        this.employeesCompany = employeesCompany;
    }

    public Month getWork_month() {
        return Work_month;
    }

    public void setWork_month(Month work_month) {
        Work_month = work_month;
    }

    public Integer getWork_year() {
        return Work_year;
    }

    public void setWork_year(Integer work_year) {
        Work_year = work_year;
    }

    public Integer getWork_day() {
        return Work_day;
    }

    public void setWork_day(Integer work_day) {
        Work_day = work_day;
    }
}
