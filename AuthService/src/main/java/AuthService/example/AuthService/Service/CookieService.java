package AuthService.example.AuthService.Service;

import org.springframework.http.ResponseCookie;

public class CookieService {
    public ResponseCookie postHttpOnlyCookie(String refreshToken) {
        if (refreshToken.isBlank() || refreshToken.isEmpty()) {
            return null;
        }
        return ResponseCookie.from("refresh_token", refreshToken)
                .httpOnly(true)
                //.secure(true)        // true nếu dùng HTTPS
                .path("/api/auth/refresh")
                .maxAge(7 * 24 * 60 * 60) // 7 ngày
                .sameSite("Strict")
                .build();
    }
}
