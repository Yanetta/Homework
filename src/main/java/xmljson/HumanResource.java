package xmljson;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * @author spasko
 */
@XmlAccessorType(XmlAccessType.PROPERTY)
public class HumanResource extends Person {
    private int startWorkYear;

    public HumanResource() {
        super();
    }

    public HumanResource(String name, String surname, int yearOfBorn, int startWorkYear) {
        super(name, surname, yearOfBorn);
        this.startWorkYear = startWorkYear;
    }

    public int getStartWorkYear() {
        return startWorkYear;
    }

    public void setStartWorkYear(int startWorkYear) {
        this.startWorkYear = startWorkYear;
    }

    @Override
    public String toString() {
        return "HumanResource [startWorkYear=" + startWorkYear + ", " + super.toString() + "]";
    }

}

