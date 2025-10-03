package AuthService.example.AuthService.Controllers;
import AuthService.example.AuthService.Dtos.LoginRequest;
import AuthService.example.AuthService.Dtos.RefreshRequest;
import AuthService.example.AuthService.Service.CookieService;
import AuthService.example.AuthService.Service.CustomUserDetailService;
import AuthService.example.AuthService.Utils.JwtUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final CustomUserDetailService userDetailsService;
    private final CookieService cookieService;

    public AuthController(CustomUserDetailService userDetailsService,
                          CookieService cookieService) {
        this.userDetailsService = userDetailsService;
        this.cookieService = cookieService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // TODO: Check username/password trong DB (UserDetailsService)
        UserDetails userDetails = userDetailsService.loadUserLogin(loginRequest.getEmail(),
                loginRequest.getPassword());
        if (userDetails != null) {
            String accessToken = JwtUtils.generateAccessToken(loginRequest.getEmail());
            String refreshToken = JwtUtils.generateRefreshToken(loginRequest.getEmail());

            ResponseCookie cookie = cookieService.postHttpOnlyCookie(refreshToken);

            Map<String, Object> response = new HashMap<>();
            response.put("accessToken", accessToken);
            response.put("refreshToken", refreshToken);
            response.put("expiresIn", 15 * 60); // 15 giây

            return ResponseEntity.ok()
                    .header(HttpHeaders.SET_COOKIE, cookie.toString())
                    .body(response);
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody RefreshRequest request) {
        if (JwtUtils.validateToken(request.getRefreshToken())) {
            String username = JwtUtils.getUsername(request.getRefreshToken());
            String newAccessToken = JwtUtils.generateAccessToken(username);
            Map<String, Object> response = new HashMap<>();
            response.put("accessToken", newAccessToken);

            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(401).body("Invalid refresh token");
    }
}
