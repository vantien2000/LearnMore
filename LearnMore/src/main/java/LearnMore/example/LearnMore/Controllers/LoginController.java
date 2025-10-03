package LearnMore.example.LearnMore.Controllers;

import LearnMore.example.LearnMore.Exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Consumer;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login() {

        return "login to dashboard!";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable int id) {
        if (id != 1) {
            throw new ResourceNotFoundException("User not found width id "+ id);
        }
        return "UserId 1";
    }
}