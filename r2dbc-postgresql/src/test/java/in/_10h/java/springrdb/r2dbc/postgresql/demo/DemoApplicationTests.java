package in._10h.java.springrdb.r2dbc.postgresql.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest(properties={
	"spring.profiles.active[0]=default",
	"spring.profiles.include[0]=test",
})
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
