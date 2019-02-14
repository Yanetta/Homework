package workwithJDBC;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Order {
    private Product product;
    private BigDecimal orderNum;
    private Date orderDate;
    private BigDecimal amount;
    private BigDecimal qty;
    private String mfr;

    public Order() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
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
