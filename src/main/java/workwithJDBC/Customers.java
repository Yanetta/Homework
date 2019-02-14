package workwithJDBC;

import java.math.BigDecimal;

public class Customers {
    private BigDecimal custNum;
    private BigDecimal custRep;
    private BigDecimal creditLimit;
    private String company;

    public Customers() {
    }

    public BigDecimal getCustNum() {
        return custNum;
    }

    public void setCustNum(BigDecimal custNum) {
        this.custNum = custNum;
    }

    public BigDecimal getCustRep() {
        return custRep;
    }

    public void setCustRep(BigDecimal custRep) {
        this.custRep = custRep;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
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
                "custNum=" + custNum +
                ", custRep=" + custRep +
                ", creditLimit=" + creditLimit +
                ", company='" + company + '\'' +
                '}';
    }
}
