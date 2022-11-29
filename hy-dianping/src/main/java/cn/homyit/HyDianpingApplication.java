package cn.homyit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class HyDianpingApplication {

    public static void main(String[] args) {
        SpringApplication.run(HyDianpingApplication.class, args);
    }

}
