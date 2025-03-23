package com.whitley.rps.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    private final Random random = new Random();
    private int wins = 0;
    private final String[] choices = {"rock", "paper", "scissors"};

    public String getServerMove() {
        return choices[random.nextInt(3)];
    }

    public String getResult(String playerMove, String serverMove) {
        if (playerMove.equals(serverMove)) {
            return "It's a tie!";
        } else if ((playerMove.equals("rock") && serverMove.equals("scissors")) ||
                   (playerMove.equals("paper") && serverMove.equals("rock")) ||
                   (playerMove.equals("scissors") && serverMove.equals("paper"))) {
            wins++;
            return "You win!";
        } else {
            return "You lose!";
        }
    }

    public int getWins() {
        return wins;
    }
}
