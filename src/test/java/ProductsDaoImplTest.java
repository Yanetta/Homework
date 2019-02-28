import JPAwork.Products;
import JPAwork.ProductsDaoImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import java.sql.SQLException;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductsDaoImplTest {
    private ProductsDaoImpl productsDao = new ProductsDaoImpl();

    @Test
    public void testFindOrderById() throws SQLException {
        System.out.println("findProductById ____________________");
        Products products = productsDao.findProductsrById("41002");
        System.out.println(products.getOrdersSet());
        assertNotNull(products);
    }
}
