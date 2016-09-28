package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import spittr.data.JdbcSpittleRepository;
import spittr.web.HomeController;
import spittr.web.SpitterController;
import spittr.web.SpittleController;

@Configuration
@EnableWebMvc
//@ComponentScan("spittr.web")
@ComponentScan(basePackageClasses = {HomeController.class, SpittleController.class, SpitterController.class})
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver resourceView = new InternalResourceViewResolver();
		resourceView.setPrefix("/WEB-INF/views/");
		resourceView.setSuffix(".jsp");
		resourceView.setExposeContextBeansAsAttributes(true);

		return resourceView;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
