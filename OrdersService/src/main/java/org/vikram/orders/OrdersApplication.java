package org.vikram.orders;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class OrdersApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }

    @Autowired
    OrderRepo ordersRepo;

    @Override
    public void run(String... args) throws Exception {

        ordersRepo.save(new Orders(List.of(1), 1));
        ordersRepo.save(new Orders(List.of(2), 2));
        ordersRepo.save(new Orders(List.of(3, 4), 3));
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(ordersRepo.findById(1).get()));
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }
}
