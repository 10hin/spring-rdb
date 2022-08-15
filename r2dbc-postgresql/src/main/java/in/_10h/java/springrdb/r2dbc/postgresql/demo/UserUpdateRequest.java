package in._10h.java.springrdb.r2dbc.postgresql.demo;

import in._10h.java.springrdb.r2dbc.postgresql.demo.r2dbcrepositories.UserEntity;
import lombok.NonNull;
import lombok.Value;
import org.springframework.lang.Nullable;

@Value
public class UserUpdateRequest {

    @NonNull
    Long id;
    @NonNull
    String name;
    @Nullable
    Integer age;
    @Nullable
    String memo;

    @org.springframework.lang.NonNull
    public UserEntity toEntity() {
        return new UserEntity(
                this.id,
                this.name,
                this.age,
                this.memo
        );
    }

}
