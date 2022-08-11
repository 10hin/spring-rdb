package in._10h.java.springrdb.r2dbc.postgresql.demo;

import lombok.NonNull;
import lombok.Value;

@Value
public class UserDraftRequest {

    @NonNull
    String name;
    Integer age;
    String memo;

    @org.springframework.lang.NonNull
    public UserEntity toEntity() {
        return new UserEntity(
                null,
                this.name,
                this.age,
                this.memo
        );
    }
}
