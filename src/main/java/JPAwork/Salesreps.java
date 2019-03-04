package JPAwork;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SALESREPS", schema = "MA_STUDENT")
public class Salesreps implements Serializable {

    @Id
    @Column(name = "EMPL_NUM")
    private BigDecimal empl_num;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REP_OFFICE")
    private Offices offices;

    @Temporal(TemporalType.DATE)
    @Column(name = "HIRE_DATE")
    private Date hire_date;

    @Column(name = "AGE")
    private BigDecimal age;

    @Column(name = "SALES")
    private BigDecimal sales;

    @Column(name = "QUOTA")
    private BigDecimal quota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER")
    private Salesreps salesreps;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "salesreps")
    private Set<Offices> officesSet = new HashSet<Offices>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "salesreps")
    private Set<Customers> customersSet = new HashSet<Customers>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "salesreps")
    private Set<Orders> ordersSet = new HashSet<Orders>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "salesreps")
    private Set<Salesreps> salesrepsSet = new HashSet<Salesreps>(0);


    public Salesreps() {
    }

    public Salesreps(BigDecimal empl_num, String name, String title, Offices offices, Date hire_date, BigDecimal age, BigDecimal sales, BigDecimal quota, Salesreps salesreps, Set<Offices> officesSet, Set<Customers> customersSet, Set<Orders> ordersSet, Set<Salesreps> salesrepsSet) {
        this.empl_num = empl_num;
        this.name = name;
        this.title = title;
        this.offices = offices;
        this.hire_date = hire_date;
        this.age = age;
        this.sales = sales;
        this.quota = quota;
        this.salesreps = salesreps;
        this.officesSet = officesSet;
        this.customersSet = customersSet;
        this.ordersSet = ordersSet;
        this.salesrepsSet = salesrepsSet;
    }

    public BigDecimal getEmpl_num() {
        return empl_num;
    }

    public void setEmpl_num(BigDecimal empl_num) {
        this.empl_num = empl_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Offices getOffices() {
        return offices;
    }

    public void setOffices(Offices rep_office) {
        this.offices = rep_office;
    }

    public Set<Customers> getCustomersSet() {
        return customersSet;
    }

    public void setCustomersSet(Set<Customers> customers) {
        this.customersSet = customers;
    }

    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> orders) {
        this.ordersSet = orders;
    }

    public Date getHire_date() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date = hire_date;
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    public Salesreps getSalesreps() {
        return salesreps;
    }

    public void setSalesreps(Salesreps manager) {
        this.salesreps = manager;
    }

    public Set<Offices> getOfficesSet() {
        return officesSet;
    }

    public void setOfficesSet(Set<Offices> offices) {
        this.officesSet = offices;
    }

    public Set<Salesreps> getSalesrepsSet() {
        return salesrepsSet;
    }

    public void setSalesrepsSet(Set<Salesreps> salesrepsSet) {
        this.salesrepsSet = salesrepsSet;
    }

    @Override
    public String toString() {
        return "\n" + "Salesreps{" + "\n" +
                "empl_num=" + empl_num +
                "," + "\n" + "name='" + name + '\'' +
                "," + "\n" + "title='" + title + '\'' +
                //"," + "\n" + "offices=" + offices +
                ", " + "\n" + "hire_date=" + hire_date +
                "," + "\n" + "age=" + age +
                ", " + "\n" + "sales=" + sales +
                ", " + "\n" + "quota=" + quota +
                //", salesreps=" + salesreps +
//                ","+"\n"+"officesSet=" + officesSet +
//                ","+"\n"+"customersSet=" + customersSet +
//                ","+"\n"+"ordersSet=" + ordersSet +
//                ","+"\n"+"salesrepsSet=" + salesrepsSet +
                '}';
    }
}