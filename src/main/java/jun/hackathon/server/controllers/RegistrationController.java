package jun.hackathon.server.controllers;

import jun.hackathon.server.models.User;
import jun.hackathon.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    private final UserRepository userRepo;

    @Autowired
    public RegistrationController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping()
    public User register(@RequestBody User user) {
        return userRepo.save(user);
    }
}
