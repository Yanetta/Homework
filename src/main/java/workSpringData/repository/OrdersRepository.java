package workSpringData.repository;

import JPAwork.Orders;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository <Orders, BigDecimal> {
    @Cacheable("orderCashed")
    List<Orders> findByAmountBetween(BigDecimal minQty, BigDecimal maxQty);
    //List<Orders> findByCustomers_ (BigDecimal minQty, BigDecimal maxQty);

}
