package JPAwork;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ORDERS", schema = "MA_STUDENT")
public class Order implements java.io.Serializable {
    @Column(name = "PRODUCT")
    private String product;
    @Id
    @Column(name = "ORDER_NUM")
    private BigDecimal orderNum;
    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "AMOUNT")
    private BigDecimal amount;
    @Column(name = "Qty")
    private BigDecimal qty;
    private String mfr;

    public Order() {
    }

    public Order(String product, BigDecimal orderNum, Date orderDate, BigDecimal amount, BigDecimal qty, String mfr) {
        this.product = product;
        this.orderNum = orderNum;
        this.orderDate = orderDate;
        this.amount = amount;
        this.qty = qty;
        this.mfr = mfr;
    }


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }



    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    @Column(name = "MFR")
    public String getMfr() {
        return mfr;
    }

    public void setMfr(String mfr) {
        this.mfr = mfr;
    }

    @Override
    public String toString() {
        return "Order{" +
                "product=" + product +
                ", orderNum=" + orderNum +
                ", orderDate=" + orderDate +
                ", amount=" + amount +
                ", qty=" + qty +
                ", mfr='" + mfr + '\'' +
                '}';
    }
}


