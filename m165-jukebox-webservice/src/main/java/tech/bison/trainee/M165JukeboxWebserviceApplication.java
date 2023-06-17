package tech.bison.trainee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "tech.bison.trainee.server")
@EnableMongoRepositories(basePackages = "tech.bison.trainee.server.persistence")
public class M165JukeboxWebserviceApplication {

  public static void main(String[] args) {
    SpringApplication.run(M165JukeboxWebserviceApplication.class, args);
  }

}
