package com.whitley.rps.controller;

import com.whitley.rps.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    private final GameService gameService;

    public ViewController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String index() {
        return "index"; // maps to src/main/resources/templates/index.html
    }

    @GetMapping("/play")
    public String play(@RequestParam(name = "move", required = true) String move, Model model) {
        String serverMove = gameService.getServerMove();
        String result = gameService.getResult(move, serverMove);

        model.addAttribute("playerMove", move);
        model.addAttribute("serverMove", serverMove);
        model.addAttribute("result", result);
        model.addAttribute("wins", gameService.getWins());

        return "result"; // maps to src/main/resources/templates/result.html
    }
}
