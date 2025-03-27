package ua.karazin.moviesprofileitemsquery;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.Instant;
import java.util.UUID;

@RedisHash("profiles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {
    @Id
    @NotBlank
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    private boolean isConfirmed;

    @NotNull
    private Instant createdAt;
}
