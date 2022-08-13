package in._10h.java.springrdb.r2dbc.postgresql.demo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "user_tbl")
public class UserEntity {

    public UserEntity() {
        this.id = null;
    }

    @Id
    private final Long id;

    @NonNull
    private String name;

    @Nullable
    private Integer age;

    @Nullable
    private String memo;

    @NonNull
    public UserEntity withId(final Long id) {
        return new UserEntity(
                id,
                this.name,
                this.age,
                this.memo
        );
    }

}
