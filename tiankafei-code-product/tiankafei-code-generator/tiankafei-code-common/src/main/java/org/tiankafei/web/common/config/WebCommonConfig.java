package org.tiankafei.web.common.config;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.math.BigInteger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * @author tiankafei
 * @since 1.0
 **/
@Configurable
@ComponentScan(basePackages = "org.tiankafei.web.common")
public class WebCommonConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        return restTemplate;
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jacksonLongToSring() {
        Jackson2ObjectMapperBuilderCustomizer customizer = new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                jacksonObjectMapperBuilder.serializerByType(BigInteger.class, ToStringSerializer.instance);
                jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance);
                jacksonObjectMapperBuilder.serializerByType(Long.TYPE, ToStringSerializer.instance);
            }
        };
        return customizer;
    }

}
