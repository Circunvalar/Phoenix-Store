package ucentral.software.PhoenixStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ucentral.software.PhoenixStore")
public class PhoenixStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoenixStoreApplication.class, args);
    }

}
