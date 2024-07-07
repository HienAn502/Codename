package personal.codename.services.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.codename.repositories.*;
import personal.codename.services.GameSessionService;

@Service
public class GameSessionServiceImpl implements GameSessionService {
    @Autowired
    private GameSessionRepository gameSessionRepository;

    @Autowired
    private HintRepository hintRepository;

    @Autowired
    private GuessRepository guessRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private PlayerRepository playerRepository;
}
