package cz.prague.home.js;

import cz.prague.home.js.controller.CommandLineController;
import org.mockito.Mockito;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CommandLineRunner.class))
@EnableAutoConfiguration
public class TestApplicationConfiguration {

    @Bean
    @Primary
    public CommandLineController commandLineController() {
        CommandLineController b = Mockito.mock(CommandLineController.class);
        return b;
    }
}
