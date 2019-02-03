package xmljson;
/**
 * @author spasko
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@XmlRootElement(name = "MateGroup")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonPropertyOrder({ "room",  "teacher", "students", "humanResources", "rector", "books"})
public class MateGroup implements Serializable {
    @XmlElement(type = Teacher.class)
    private Person teacher;
    @XmlElementWrapper(name = "students")
    @XmlElement(name = "student")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
    @JsonSubTypes({ @JsonSubTypes.Type(value = Teacher.class, name = "teacher"),
            @JsonSubTypes.Type(value = Student.class, name = "student") })
    private List<Person> students;
    @XmlElement(required = true, nillable = false)
    private Room room;
    @XmlElementWrapper(name = "hrs")
    @XmlElement(name = "humanResource")
    private Set<HumanResource> humanResources;
    private int id;
    @XmlElement(name = "rector")
    private Rector rector;
    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
    @JsonSubTypes({ @JsonSubTypes.Type(value = Book.class, name = "book")})
    private List<Book> books;

    public MateGroup(Rector rector, Teacher teacher, List<Person> students, Room room, Set<HumanResource> humanResources, List<Book> books) {
        this.rector = rector;
        this.teacher = teacher;
        this.students = students;
        this.room = room;
        this.humanResources = humanResources;
        this.books = books;

    }

    public MateGroup() {
    }

    public Person getTeacher() {
        return teacher;
    }

    @XmlElement
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<HumanResource> getHumanResources() {
        return humanResources;
    }

    public void setHumanResources(Set<HumanResource> humanResources) {
        this.humanResources = humanResources;
    }

    public Rector getRector() {
        return rector;
    }

    public void setRector(Rector rector) {
        this.rector = rector;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "MateGroup [teacher=" + teacher + ", rector=" + rector +", students=" + students + ", room=" + room + ", humanResources="
                + humanResources + ", books=" + books + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static MateGroup mateGroupExampleCreator() {
        MateGroup mateGroup = new MateGroup();
        mateGroup.setId(18122018);


        Teacher teacher = new Teacher("Serhii", "Pasko", 1988, 666, 30, "Java");
        mateGroup.setTeacher(teacher);

        Room room = new Room("Kiyv", "Tarasivska", 16, 28);
        mateGroup.setRoom(room);

        Set<HumanResource> humanResources = new HashSet<>();
        humanResources.add(new HumanResource("Karmen", "", 1990, 2015));
        humanResources.add(new HumanResource("Efiria", "", 1989, 2016));
        mateGroup.setHumanResources(humanResources);

        List<Person> students = new ArrayList<>();
        students.add(new Student("Iza", "Rabinovish", 1997, 5));
        students.add(new Student("Abram", "Kolom", 1998, 4));
        students.add(new Teacher("Moisha", "Stefan", 1990, 666, 25, "Python"));
        mateGroup.setStudents(students);

        Rector rector = new Rector("Grammy", 10000);
        mateGroup.setRector(rector);

        List<Book> books = new ArrayList<>();
        books.add(new Book("Zakhar Berkut", 300));
        books.add(new Book("Kobzar", 500));
        books.add(new Book("Kolobok", 10));
        mateGroup.setBooks(books);

        return mateGroup;
    }
}

