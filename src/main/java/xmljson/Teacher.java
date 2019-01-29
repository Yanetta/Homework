package xmljson;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author spasko
 */
@XmlRootElement(name = "teacher")
public class Teacher extends Person {
    private int salary;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("daysOfVacation")
    private int daysOfVacation;

    public Teacher(String name, String surname, int yearOfBorn, int salary, int daysOfVacation, String subject) {
        super(name, surname, yearOfBorn);
        this.salary = salary;
        this.daysOfVacation = daysOfVacation;
        this.subject = subject;
    }

    public Teacher() {
        super();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getDaysOfVacation() {
        return daysOfVacation;
    }

    public void setDaysOfVacation(int daysOfVacation) {
        this.daysOfVacation = daysOfVacation;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher [salary=" + salary + " " + super.toString() + "]";
    }

}