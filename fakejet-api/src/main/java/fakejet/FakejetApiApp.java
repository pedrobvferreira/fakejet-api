package fakejet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FakejetApiApp {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        SpringApplication.run(FakejetApiApp.class, args);
    }
}
