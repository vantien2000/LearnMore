package LearnMore.example.LearnMore.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Table(name = "user_admin")
@AllArgsConstructor // Generates a constructor with all fields
@Data
public class UserAdmin {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String fullname;
    private String email;
    private String psw;
    private String avata_url;
    private Timestamp upload_at;
    private Timestamp created_at;
}
