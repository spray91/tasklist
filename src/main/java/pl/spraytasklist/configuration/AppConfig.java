package pl.spraytasklist.configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import pl.spraytasklist.converter.IdToCateogryConverter;
import pl.spraytasklist.converter.StringToLocalDateTimeConverter;

@Configuration
@EnableWebMvc
@ComponentScan({"pl.spraytasklist"})
@EnableJpaRepositories(basePackages = "pl.spraytasklist")
public class AppConfig implements WebMvcConfigurer {
	
	@Autowired
	IdToCateogryConverter idtocategoryconverter;
	
	@Autowired
	StringToLocalDateTimeConverter stringtolocaldatetimeconverter;
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }
    
    //@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    	registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/", "D:/workplace/git/tasklist/src/main/resources/static/")
        .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }

    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(idtocategoryconverter);    
        registry.addConverter(stringtolocaldatetimeconverter);
    }
    
}
