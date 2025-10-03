package AuthService.example.AuthService.Dtos;

import lombok.Data;

@Data
public class RefreshRequest {
    private String refreshToken;
}
