package com.meetup.recommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RecommendationServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(RecommendationServiceApplication.class, args);
    }
}
