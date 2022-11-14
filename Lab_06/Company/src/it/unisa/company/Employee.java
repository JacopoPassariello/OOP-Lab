package it.unisa.company;

public class Employee extends Staff {

    private String jobTitle;


    private float hourlyWage;

    public Employee(String name, String lastName,String jobTitle,int hourlyWage)
    {
        super(name,lastName);
        this.jobTitle = jobTitle;
        this.hourlyWage = hourlyWage;
        updateSalary();
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public float getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(float hourlyWage)
    {
        this.hourlyWage = hourlyWage;
        updateSalary();
    }

    private void updateSalary()
    {
        super.setWage(this.hourlyWage*40);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "jobTitle='" + jobTitle + '\'' +
                ", hourlyWage=" + hourlyWage +
                '}';
    }
}
