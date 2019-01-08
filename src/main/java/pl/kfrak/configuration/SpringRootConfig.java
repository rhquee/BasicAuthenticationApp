package pl.kfrak.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"pl/kfrak/service", "pl/kfrak/repository"})
public class SpringRootConfig {
}
