package JPAwork;

import java.math.BigDecimal;

public interface ProductsDao {
    Products findProductById(BigDecimal id);

}
