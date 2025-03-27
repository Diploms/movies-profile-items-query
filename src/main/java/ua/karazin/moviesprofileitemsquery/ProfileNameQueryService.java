package ua.karazin.moviesprofileitemsquery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileNameQueryService {
    private final ProfileRepository repository;

    public List<Profile> findAll() {
        return repository.findAll();
    }

    public Optional<Profile> findById(String id) {
        return repository.findById(id);
    }
}
