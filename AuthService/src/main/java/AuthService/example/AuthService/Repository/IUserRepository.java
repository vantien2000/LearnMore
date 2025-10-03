package AuthService.example.AuthService.Repository;

import AuthService.example.AuthService.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<Customer, Long> {
    @Query(value="select * from accounts a where a.email= :email and a.psw= :password", nativeQuery=true)
    Optional<Customer> findByEmailAndPass(String email, String password);
}
