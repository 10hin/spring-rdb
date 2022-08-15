package in._10h.java.springrdb.r2dbc.postgresql.demo;

import in._10h.java.springrdb.r2dbc.postgresql.demo.r2dbcrepositories.UserRepository;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.Logger;
import reactor.util.Loggers;

@RestController
public class DemoController {

    private static final Logger LOGGER = Loggers.getLogger(DemoController.class);

    @NonNull
    private final UserRepository userRepository;

    public DemoController(
            @NonNull
            final UserRepository userRepository
    ) {

        this.userRepository = userRepository;

    }

    @GetMapping(
            path = {
                    "/users/{user_id}",
                    "/users/{user_id}/",
            }
    )
    public Mono<UserResponse> getUser(
            @PathVariable("user_id") final Long userID
    ) {

        return this.userRepository.findById(userID)
                .map(UserResponse::from);

    }

    @PostMapping(
            path= {
                    "/users",
                    "/users/",
            }
    )
    public Mono<UserResponse> createNewUser(
        @RequestBody Mono<UserDraftRequest> userDraft
    ) {

        return userDraft.map(UserDraftRequest::toEntity)
                .flatMap(this.userRepository::save)
                .map(UserResponse::from);

    }

    @PutMapping(
            path = {
                    "/users/{user_id}",
                    "/users/{user_id}/",
            }
    )
    public Mono<UserResponse> upsertUser(
            @PathVariable("user_id") Long userID,
            @RequestBody Mono<UserDraftRequest> userUpdateProperties
    ) {

        return userUpdateProperties.map(UserDraftRequest::toEntity)
                .map(entity -> entity.withId(userID))
                .flatMap(this.userRepository::save)
                .map(UserResponse::from);

    }

    @PutMapping(
            path = {
                    "/users",
                    "/users/",
            }
    )
    public Mono<UserResponse> upsertUser(
            @RequestBody Mono<UserUpdateRequest> userUpdate
    ) {

        return userUpdate.map(UserUpdateRequest::toEntity)
                .flatMap(this.userRepository::save)
                .map(UserResponse::from);

    }

    @DeleteMapping(path = {
            "/users/{user_id}",
            "/users/{user_id}/",
    })
    public Mono<Long> deleteUser(
            @PathVariable("user_id") Long userID
    ) {

        return this.userRepository.deleteById(userID)
                .map(_void -> userID);

    }

}
