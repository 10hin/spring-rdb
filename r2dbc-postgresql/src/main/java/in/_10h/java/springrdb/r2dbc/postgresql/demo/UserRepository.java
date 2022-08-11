package in._10h.java.springrdb.r2dbc.postgresql.demo;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<UserEntity, String> {
}
