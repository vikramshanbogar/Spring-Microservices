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


        Product p1 = new Product(1);
        Product p2 = new Product(2);
        Product p3 = new Product(3);
        Product p4 = new Product(4);
        ordersRepo.save(new Orders(List.of(p1), 1));
        ordersRepo.save(new Orders(List.of(p2), 2));
        ordersRepo.save(new Orders(List.of(p3, p4), 3));
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
