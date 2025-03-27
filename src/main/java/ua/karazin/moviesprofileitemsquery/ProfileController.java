package ua.karazin.moviesprofileitemsquery;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileNameQueryService profileNameQueryService;

    @GetMapping
    public List<Profile> findAll() {
        return profileNameQueryService.findAll();
    }

    @GetMapping("/{id}")
    public Profile findById(@PathVariable String id) {
        return profileNameQueryService.findById(id).orElseThrow();
    }
}
