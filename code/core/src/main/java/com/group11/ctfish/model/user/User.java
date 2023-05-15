package com.group11.ctfish.model.user;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final List<LifeObserver> lifeObservers = new ArrayList<>();
    private final List<ScoreObserver> scoreObservers = new ArrayList<>();
    private final String username;
    private int score;
    private int highScore;
    private int lives;

    public User(String username) {
        this.username = username;
        lives = 3;
        score = 0;
        highScore = 0;
    }

    private void updateLifeObservers() {
        lifeObservers.forEach(observer -> observer.update(lives));
    }
    private void updateScoreObservers() {
        scoreObservers.forEach(observer -> observer.updateScore(score));
    }

    public String getUsername() {
        return this.username;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLives() {
        return lives;
    }

    public void updateScore(int score){
        this.score += score;
        scoreSoundGenerator();
        updateScoreObservers();
    }

    public void addLife(){
        if(lives < 3) {
            this.lives++;
            updateLifeObservers();
        }
    }

    public void removeLife(){
        if(lives >= 1) {
            this.lives--;
            heartLostSoundGenerator();
            updateLifeObservers();
        }
    }
    public void resetGame(){
        if(score >= highScore){
            highScore = score;
        }
        this.lives= 3;
        this.score = 0;
        updateLifeObservers();
        updateScoreObservers();
    }

    public void observeLife(LifeObserver observer) {
        observer.update(lives);
        lifeObservers.add(observer);
    }

    public void observeScore(ScoreObserver observer) {
        observer.updateScore(score);
        scoreObservers.add(observer);

    }

    //Sound is implemented in both view and model...
    // I am Grateful for any assistance regarding possible solutions to this problem :)
    private static void heartLostSoundGenerator() {
        Sound heartlost = Gdx.audio.newSound(Gdx.files.internal("heartlost.mp3"));
        heartlost.play();
    }

    private static void scoreSoundGenerator() {
        Sound score = Gdx.audio.newSound(Gdx.files.internal("scoresound.mp3"));
        score.play();
    }

}
