package org.codenergic.akinabot.line.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by diasa on 2/19/17.
 */
@Configuration
public class BaseConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder.build();
    }

}
