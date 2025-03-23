package com.whitley.rps.controller;

import com.whitley.rps.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiController {

    private final GameService gameService;

    public ApiController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/api/play")
    public Map<String, Object> play(@RequestParam String move) {
        String serverMove = gameService.getServerMove();
        String result = gameService.getResult(move, serverMove);

        Map<String, Object> response = new HashMap<>();
        response.put("playerMove", move);
        response.put("serverMove", serverMove);
        response.put("result", result);
        response.put("wins", gameService.getWins());

        return response;
    }
}