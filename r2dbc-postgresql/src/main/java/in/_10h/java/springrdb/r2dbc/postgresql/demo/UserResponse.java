package in._10h.java.springrdb.r2dbc.postgresql.demo;

import in._10h.java.springrdb.r2dbc.postgresql.demo.r2dbcrepositories.UserEntity;
import lombok.NonNull;
import lombok.Value;

@Value
public class UserResponse {

    @NonNull
    Long id;
    @NonNull
    String name;
    Integer age;
    String memo;

    @org.springframework.lang.NonNull
    public static UserResponse from(final UserEntity entity) {
        return new UserResponse(
                entity.getId(),
                entity.getName(),
                entity.getAge(),
                entity.getMemo()
        );
    }

}
