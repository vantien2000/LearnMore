package AuthService.example.AuthService.Repository;

import AuthService.example.AuthService.Model.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserAdminRepository extends JpaRepository<UserAdmin, Long> {
    Optional<UserAdmin> findByUsername(String username);
}
