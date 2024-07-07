package personal.codename.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.codename.services.serviceImplements.GameSessionServiceImpl;
import personal.codename.services.serviceImplements.UserServiceImpl;

@Controller
@RequestMapping("/game-session")
public class GameSessionController {
    @Autowired
    private GameSessionServiceImpl gameSessionService;
}
