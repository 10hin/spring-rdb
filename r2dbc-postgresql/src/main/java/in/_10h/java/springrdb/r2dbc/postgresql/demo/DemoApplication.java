package in._10h.java.springrdb.r2dbc.postgresql.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.lang.NonNull;
import reactor.util.Loggers;

@SpringBootApplication
@EnableR2dbcRepositories
public class DemoApplication {

	public static void main(@NonNull String[] args) {
		Loggers.useSl4jLoggers();
		SpringApplication.run(DemoApplication.class, args);
	}

}
