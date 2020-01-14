package com.unitbv.resourcesmanager.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
public class WebConfiguration implements WebMvcConfigurer
{

    @Autowired
    private MessageSource messageSource;

    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/pageNotFound").setViewName("pageNotFound");
    }

    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        return factory;
    }

    @Bean
    public SpringSecurityDialect securityDialect() {
        return new SpringSecurityDialect();
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> containerCustomizer() {
        return container -> {
            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
                    "/pageNotFound"));
        };
    }
}