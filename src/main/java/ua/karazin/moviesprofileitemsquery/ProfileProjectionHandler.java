package ua.karazin.moviesprofileitemsquery;

import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.EventMessage;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.karazin.moviesbaseevents.profiles.revision1.ProfileConfirmedEvent1;
import ua.karazin.moviesbaseevents.profiles.revision1.ProfileCreatedEvent1;
import ua.karazin.moviesbaseevents.profiles.revision1.ProfileUpdatedEvent1;

@Component
@RequiredArgsConstructor
public class ProfileProjectionHandler {
    private final ProfileRepository repository;

    @EventHandler
    private void on(ProfileCreatedEvent1 event, EventMessage<?> message) {
        repository.save(Profile.builder()
                .id(event.id())
                .name(event.dto().name())
                .email(event.dto().email())
                .createdAt(message.getTimestamp())
                .build());
    }

    @EventHandler
    @Transactional
    void on(ProfileUpdatedEvent1 event) {
        var profile = repository.findById(event.id()).orElseThrow();
        profile.setName(event.dto().name());
        repository.save(profile);
    }

    @EventHandler
    @Transactional
    void on(ProfileConfirmedEvent1 event) {
        var profile = repository.findById(event.profileId()).orElseThrow();
        profile.setConfirmed(true);
        repository.save(profile);
    }
}
