package JPAwork;

import java.math.BigDecimal;
import java.util.Set;

public interface ProductsDao {
    Set<Products> getAllProducts();

    Products findProductsrById(String id);

    boolean insertProducts(Products products) ;

    boolean updateProducts(Products products) ;

    boolean deleteProducts(BigDecimal id) ;

}
