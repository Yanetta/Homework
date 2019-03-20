package workSpringData;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import workSpringData.repository.OrdersRepository;

import java.math.BigDecimal;

public class MainSpringData {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext("workSpringData");
        OrdersRepository ordersRepository = context.getBean(OrdersRepository.class );
       ordersRepository.findAll().forEach(System.out::println);

//        ordersRepository.findByAmountBetween(BigDecimal.valueOf(100), BigDecimal.valueOf(800)).forEach(System.out::println);
//        System.out.println("_____");
//        ordersRepository.findByAmountBetween(BigDecimal.valueOf(100), BigDecimal.valueOf(800)).forEach(System.out::println);
        //ordersRepository.findByCu Customer_CompanyLike("Ро%").forEach(System.out::println);

        context.close();
    }
}
