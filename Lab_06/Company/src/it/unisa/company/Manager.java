package it.unisa.company;

public class Manager extends Employee {

    private String expertiseArea;
    private int workedHours;



    public Manager(String name, String lastName,String jobTitle,int hourlyWage,String expertiseArea)
    {
        super(name,lastName,jobTitle,hourlyWage);
        this.expertiseArea = expertiseArea;
        updateSalary(workedHours);
    }

    public String getExpertiseArea() {
        return expertiseArea;
    }

    public void setExpertiseArea(String expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setHourlyWage(float hourlyWage)
    {
        super.setHourlyWage(hourlyWage);
        updateSalary(this.workedHours);
    }
    public void setWorkedHours(int workedHours)
    {
        this.workedHours = workedHours;
        updateSalary(workedHours);
    }

    private void updateSalary(int workedHours)
    {
        if(workedHours<=40)
        {
            setWage(workedHours*getHourlyWage());
        }
        else
        {
            int extraHours= workedHours - 40;
            setWage(40*getHourlyWage() + extraHours*getHourlyWage()*(1.5f));
        }
    }

    @Override
    public String toString() {
        return "Manager{" +
                "expertiseArea='" + expertiseArea + '\'' +
                ", workedHours=" + workedHours +
                '}';
    }
}
