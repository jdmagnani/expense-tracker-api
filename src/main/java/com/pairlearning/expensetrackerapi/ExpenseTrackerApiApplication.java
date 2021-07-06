package com.pairlearning.expensetrackerapi;

import com.pairlearning.expensetrackerapi.filters.AuthFilter;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.security.auth.login.Configuration;

@SpringBootApplication
public class ExpenseTrackerApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ExpenseTrackerApiApplication.class, args);

	}

	/**
	 * Adding filter
	 * @return FilterRegistrationBean
	 */
	@Bean
	public FilterRegistrationBean<AuthFilter> filterFilterRegistrationBean() {
		FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
		AuthFilter authFilter = new AuthFilter();
		registrationBean.setFilter(authFilter);
		registrationBean.addUrlPatterns("/api/categories/*");
		return registrationBean;

	}

//	@Bean
//	public FilterRegistrationBean<CorsFilter> corsFilter() {
//		FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.addAllowedOrigin("*");
//		config.addExposedHeader("*");
//		source.registerCorsConfiguration("/**", config);
//		registrationBean.setFilter(new CorsFilter());
//		registrationBean.setOrder(0);
//		return registrationBean;
//	}

}
