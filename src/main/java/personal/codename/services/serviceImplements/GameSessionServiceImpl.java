package personal.codename.services.serviceImplements;

import org.springframework.stereotype.Service;
import personal.codename.repositories.*;
import personal.codename.services.GameSessionService;

@Service
public class GameSessionServiceImpl implements GameSessionService {
    private GameSessionRepository gameSessionRepository;
    private HintRepository hintRepository;
    private GuessRepository guessRepository;
    private CardRepository cardRepository;
    private PlayerRepository playerRepository;
}
