package com.sap.banking.loan.configurations;

import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({ "cloud" })
@Configuration
@ServiceScan
public class CloudConfiguration {

}