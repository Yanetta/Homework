package workSpringData.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@ComponentScan("workSpringData")
public class MainMvc extends AnnotationConfigWebApplicationContext {
}
