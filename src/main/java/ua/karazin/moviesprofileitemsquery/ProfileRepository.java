package ua.karazin.moviesprofileitemsquery;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepository extends ListCrudRepository<Profile, String> {
}
