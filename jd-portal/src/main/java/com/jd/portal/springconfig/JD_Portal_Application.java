package com.jd.portal.springconfig;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = { "classpath:resource.properties" })
@ComponentScan(basePackages = "com.jd")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JD_Portal_Application {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(JD_Portal_Application.class);
	}
}
