package Google;

public class Company {
    private String nameOfCompany;
    private String companyDepartment;
    private double salary;

    public Company(String nameOfCompany, String companyDepartment, double salary) {
        this.nameOfCompany = nameOfCompany;
        this.companyDepartment = companyDepartment;
        this.salary = salary;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public String getCompanyDepartment() {
        return companyDepartment;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        //return this.nameOfCompany == null ? "" : String.format("%n%s %s %.2f" ,this.nameOfCompany ,this.companyDepartment , this.salary);
        return String.format("%s %s %.2f" ,this.nameOfCompany ,this.companyDepartment , this.salary);
    }
}
