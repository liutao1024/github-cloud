package org.cloud.mvn.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig.class)
public class AnnotationConfig {
	@Bean
	public Person getPerson(){
		return new Person();
	}
	@Bean(initMethod = "init", destroyMethod = "cleanup" )
	public Student getStudent(){
		return new Student();
	}
}
