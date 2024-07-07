package personal.codename.services.serviceImplements;

import org.springframework.stereotype.Service;
import personal.codename.repositories.PlayerRepository;
import personal.codename.repositories.UserRepository;
import personal.codename.services.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;

    private UserRepository userRepository;
}
