package AuthService.example.AuthService.Service;

import AuthService.example.AuthService.Repository.IUserRepository;
import AuthService.example.AuthService.Model.Customer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService {
    private final IUserRepository userRepository;
    public CustomUserDetailService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDetails loadUserLogin(String username, String password) throws UsernameNotFoundException {
        //Tìm trong customer
        Optional<Customer> customerOpt = userRepository.findByEmailAndPass(username, password);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            return User.builder()
                    .username(customer.getEmail())
                    .password(customer.getPsw())
                    .build();
        }

        // Tìm trong admin
//        Optional<UserAdmin> adminOpt = userAdminRepository.findByUsername(username);
//        if (adminOpt.isPresent()) {
//            UserAdmin admin = adminOpt.get();
//            return User.builder()
//                    .username(admin.getUsername())
//                    .password(admin.getPsw())
//                    .roles("ADMIN")
//                    .build();
//        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}
