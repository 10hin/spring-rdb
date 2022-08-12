package in._10h.java.springrdb.r2dbc.mysql.demo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserEntity {

    public UserEntity() {
        this.id = null;
    }

    @Id
    private final String id;

    @NonNull
    private String name;

    @Nullable
    private Integer age;

    @Nullable
    private String memo;

    @NonNull
    public UserEntity withId(final String id) {
        return new UserEntity(
                id,
                this.name,
                this.age,
                this.memo
        );
    }

}
