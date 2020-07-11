package api.SpringSecurity;

import api.SpringSecurity.models.MyUserDetails;
import api.SpringSecurity.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String phone_number) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByPhone(phone_number);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found "+ phone_number));

        return user.map(MyUserDetails::new).get();
    }
}
