package xmljson;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author spasko
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Student extends Person {
    private int mark;

    @Override
    @XmlTransient
    @JsonIgnore
    public String getSurname() {
        return super.getSurname();
    }

    public Student() {

    }

    public Student(String name, String surname, int yearOfBorn, int mark) {
        super(name, surname, yearOfBorn);
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}