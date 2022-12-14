package mk.finki.ukim.mk.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Wp202223Application {

    public static void main(String[] args) {
        SpringApplication.run(Wp202223Application.class, args);
    }

}
