package workwithJDBC;

import java.math.BigDecimal;

public class Product {
    private String mfrID;
    private String productID;
    private String description;
    private BigDecimal price;
    private BigDecimal qtyOnHand;

    public Product(){};

    public Product(String productID) {
        this.productID = productID;
        }

    public String getMfrID() {
        return mfrID;
    }

    public void setMfrID(String mfrID) {
        this.mfrID = mfrID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(BigDecimal qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "mfrID='" + mfrID + '\'' +
                ", productID='" + productID + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", qtyOnHand=" + qtyOnHand +
                '}';
    }
}
