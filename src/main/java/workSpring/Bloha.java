package workSpring;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Bloha {
    private String id;
    public Bloha(){
        id = "cat citizen - " + (int)(Math.random()*1000);
    }

    @Override
    public String toString() {
        return "Bloha{" +
                "id='" + id + '\'' +
                '}';
    }
}
