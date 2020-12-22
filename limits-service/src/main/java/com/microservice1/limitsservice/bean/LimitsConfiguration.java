package com.microservice1.limitsservice.bean;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class LimitsConfiguration {

    private int max_limit;
    private int min_limit;

    private LimitsConfiguration(){

    }
    public LimitsConfiguration(int max, int min){
        super();
        this.max_limit = max;
        this.min_limit = min;
    }


    public int getMax_limit() {
        return max_limit;
    }

    public void setMax_limit(int max_limit) {
        this.max_limit = max_limit;
    }

    public int getMin_limit() {
        return min_limit;
    }

    public void setMin_limit(int min_limit) {
        this.min_limit = min_limit;
    }
}
