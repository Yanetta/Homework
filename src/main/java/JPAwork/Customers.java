package JPAwork;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "CUSTOMERS", schema = "MA_STUDENT")
public class Customers implements java.io.Serializable {
    @Id
    @Column(name = "CUST_NUM")
    private BigDecimal cust_num;
    @Column(name = "CUST_REP")
    private BigDecimal cust_rep;
    @Column(name = "CREDIT_LIMIT")
    private BigDecimal credit_limit;
    @Column(name = "COMPANY")
    private String company;

    public Customers() {
    }

    public Customers(BigDecimal cust_num, BigDecimal cust_rep, BigDecimal credit_limit, String company) {
        this.cust_num = cust_num;
        this.cust_rep = cust_rep;
        this.credit_limit = credit_limit;
        this.company = company;
    }

    public BigDecimal getCust_num() {
        return cust_num;
    }

    public void setCust_num(BigDecimal cust_num) {
        this.cust_num = cust_num;
    }

    public BigDecimal getCust_rep() {
        return cust_rep;
    }

    public void setCust_rep(BigDecimal cust_rep) {
        this.cust_rep = cust_rep;
    }

    public BigDecimal getCredit_limit() {
        return credit_limit;
    }

    public void setCredit_limit(BigDecimal credit_limit) {
        this.credit_limit = credit_limit;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "cust_num=" + cust_num +
                ", cust_rep=" + cust_rep +
                ", credit_limit=" + credit_limit +
                ", company='" + company + '\'' +
                '}';
    }
}
