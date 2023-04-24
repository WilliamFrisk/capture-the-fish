package com.group11.ctfish.model.user;

public class User {
    private String username;
    private int score;
    private int highscore;
    private int lives;

    public User(String username) {
        this.username = username;
        lives= 3;
        score = 0;
        highscore = 0;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getScore() {
        return score;
    }
    /*
    public void setScore(int score) {
        this.score = score;
    }*/

    public int getLives() {
        return lives;
    }
    /*
    public void setLives(int lives) {
        this.lives = lives;
    }*/
    public int updateScore(int score){
        this.score += score;
        return this.score;
    }

    public void addLife(){
        if(lives < 3)
            this.lives++;
    }

    public void removeLife(){
        if(lives >= 1)
            this.lives--;
    }
    public void resetGame(){
        if(score >= highscore){
            highscore = score;
        }
        lives= 3;
        score = 0;
    }
}
