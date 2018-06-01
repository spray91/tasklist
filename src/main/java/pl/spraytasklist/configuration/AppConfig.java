package pl.spraytasklist.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import pl.spraytasklist.converter.IdToCateogryConverter;

@EnableWebMvc
@Configuration
@ComponentScan({"pl.spraytasklist"})
@EnableJpaRepositories(basePackages = "pl.spraytasklist")
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
	IdToCateogryConverter idtocategoryconverter;
	//TODO trzbea cos tutaj wymyslic bo nie dziala mi converter
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
    

    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(idtocategoryconverter);    
    }
    
}
