package AuthService.example.AuthService.Dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

    // getter/setter
}
