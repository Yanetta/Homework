package springAnnotations;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class SushiPostProc implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Sushi) {
            ((Sushi) bean).setPrice(300);
            System.out.println("In postProcessAfterInitialization " + bean);
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Sushi) {
            ((Sushi) bean).setPrice(200);
            System.out.println("In postProcessBeforeInitialization " + bean);
        }
        return bean;
    }
}


