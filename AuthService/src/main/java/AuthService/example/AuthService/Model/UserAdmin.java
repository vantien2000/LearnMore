package AuthService.example.AuthService.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_admin")
@Data
public class UserAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String fullname;
    private String email;
    private String psw;
}
