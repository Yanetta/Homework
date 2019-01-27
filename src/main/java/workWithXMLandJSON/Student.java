package workWithXMLandJSON;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlTransient;

/**
 * @author spasko
 */
public class Student extends Person {

	@Override
	@XmlTransient
	@JsonIgnore
	public String getSurname() {
		return super.getSurname();
	}

	public Student() {

	}

	public Student(String name, String surname, int yearOfBorn) {
		super(name, surname, yearOfBorn);
	}

}
