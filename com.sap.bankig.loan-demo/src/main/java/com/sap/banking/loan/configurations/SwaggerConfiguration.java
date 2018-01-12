package com.sap.banking.loan.configurations;

import static springfox.documentation.builders.PathSelectors.regex;
import static springfox.documentation.builders.RequestHandlerSelectors.any;
import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import({ springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class,
		springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class })
public class SwaggerConfiguration {

	@Bean
	public Docket loanApplicationsApi() {
		return new Docket(SWAGGER_2).apiInfo(getApiInfo()).select().apis(any()).paths(regex("/loanapplication.*")).build();
	}

	/**
	 * Build ApiInfo
	 * 
	 * @return
	 */
	private ApiInfo getApiInfo() {

		Contact contact = new Contact("Sachin Bhosale", "https://www.linkedin.com/in/sachinbhosale/", "s.bhosale@sap.com");

		VendorExtension<String> ext = new StringVendorExtension("SAP", "SAP Labs India (Pune)");

		return new ApiInfo("Loan Application API", "Sample API for LoanApplication resource", "1.0.0", "", contact, "Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0", Arrays.asList(ext));

	}

}