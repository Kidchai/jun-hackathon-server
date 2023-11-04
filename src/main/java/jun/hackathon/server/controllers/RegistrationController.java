package jun.hackathon.server.controllers;

import jun.hackathon.server.models.User;
import jun.hackathon.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class RegistrationController {

    private final UserRepository userRepo;

    @Autowired
    public RegistrationController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping()
    public ResponseEntity<User> register(@RequestBody User user) {
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.OK);
    }
}
