package jun.hackathon.server.controllers;

import jun.hackathon.server.models.User;
import jun.hackathon.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class AuthenticationController {

    private final UserRepository userRepo;

    @Autowired
    public AuthenticationController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> login(@RequestBody User user) {
        Optional<User> existedUser = userRepo.findById(user.getEmail());
        if (existedUser.isEmpty())
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        if (!user.equals(existedUser.get()))
            return new ResponseEntity<>("Incorrect credentials", HttpStatus.FORBIDDEN);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }
}
