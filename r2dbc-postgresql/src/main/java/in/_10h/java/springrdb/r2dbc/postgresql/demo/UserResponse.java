package in._10h.java.springrdb.r2dbc.postgresql.demo;

import lombok.NonNull;
import lombok.Value;

@Value
public class UserResponse {

    @NonNull
    String id;
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
