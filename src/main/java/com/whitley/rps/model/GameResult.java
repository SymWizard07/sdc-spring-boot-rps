package com.whitley.rps.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class GameResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String playerMove;
    private String serverMove;
    private String result;
    private LocalDateTime timestamp;

    public GameResult() {
    }

    public GameResult(String playerMove, String serverMove, String result, LocalDateTime timestamp) {
        this.playerMove = playerMove;
        this.serverMove = serverMove;
        this.result = result;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public String getPlayerMove() {
        return playerMove;
    }

    public void setPlayerMove(String playerMove) {
        this.playerMove = playerMove;
    }

    public String getServerMove() {
        return serverMove;
    }

    public void setServerMove(String serverMove) {
        this.serverMove = serverMove;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}