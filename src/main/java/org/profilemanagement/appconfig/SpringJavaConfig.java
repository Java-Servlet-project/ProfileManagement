package org.profilemanagement.appconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.profilemanagement.service")
@ComponentScan(basePackages = "org.profilemanagement.dao")
public class SpringJavaConfig {

    /*
     * @Bean public PersistenceExceptionTranslationPostProcessor exceptionTranslation() { return new
     * PersistenceExceptionTranslationPostProcessor(); }
     */
}
