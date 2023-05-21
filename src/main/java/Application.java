import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"org.example"})
@EnableJpaRepositories(basePackages="org.example.repo")
@EnableTransactionManagement
@EntityScan(basePackages="org.example.ent")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
