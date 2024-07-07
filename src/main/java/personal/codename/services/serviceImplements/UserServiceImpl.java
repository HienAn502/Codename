package personal.codename.services.serviceImplements;

import org.springframework.stereotype.Service;
import personal.codename.repositories.UserRepository;
import personal.codename.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
}
