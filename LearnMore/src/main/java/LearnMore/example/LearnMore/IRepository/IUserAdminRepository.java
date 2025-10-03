package LearnMore.example.LearnMore.IRepository;

import LearnMore.example.LearnMore.Models.UserAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAdminRepository extends JpaRepository<UserAdmin, Long> {
    UserAdmin findByUsername(String username);
}
