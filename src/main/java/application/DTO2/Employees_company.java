package application.DTO2;

public class Employees_company {
    private Integer Id;
    private Employee employee;
    private Company company;
    private Double Salary;
    private Double Contribution;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public Double getContribution() {
        return Contribution;
    }

    public void setContribution(Double contribution) {
        Contribution = contribution;
    }
}
