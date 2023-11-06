package jun.hackathon.server.controllers;

import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.rsa.RSASigner;
import jun.hackathon.server.models.User;
import jun.hackathon.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Arrays;
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
        Optional<User> existedUser = userRepo.findByEmail(user.getEmail());
        if (existedUser.isEmpty())
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        if (!user.getEmail().equals(existedUser.get().getEmail()) ||
                !user.getPassword().equals(existedUser.get().getPassword()))
            return new ResponseEntity<>("Incorrect credentials", HttpStatus.FORBIDDEN);

        Signer signer = null;
        try {
            signer = RSASigner.newSHA256Signer(new String(Files.readAllBytes(Paths.get("keys/jwtRS256.key"))));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Error", HttpStatus.FORBIDDEN);
        }

        JWT jwt = new JWT()
                .setIssuedAt(ZonedDateTime.now(ZoneOffset.UTC))
                .addClaim("email", user.getEmail())
                .setExpiration(ZonedDateTime.now(ZoneOffset.UTC).plusMinutes(60));

        String encodedJWT = JWT.getEncoder().encode(jwt, signer);

        return new ResponseEntity<>(encodedJWT, HttpStatus.OK);
    }
}
