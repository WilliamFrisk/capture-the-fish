package com.group11.ctfish.model;

import com.group11.ctfish.model.fish.Fish;
import com.group11.ctfish.model.fish.FishFacade;
import com.group11.ctfish.model.quiz.QuizLogic;
import com.group11.ctfish.model.user.LifeObserver;
import com.group11.ctfish.model.user.ScoreObserver;
import com.group11.ctfish.model.user.User;
import com.group11.ctfish.model.util.Utils;

import java.util.List;
import java.util.Set;

public class ModelFacade {
    private User user;

    QuizLogic QL = new QuizLogic();

    private final FishFacade fishFacade;
    private static final ModelFacade INSTANCE = new ModelFacade();
    private final Hook hook = new Hook();

    private ModelFacade() {
        this.fishFacade = FishFacade.getInstance();
    }

    public static ModelFacade getInstance(){
        return INSTANCE;
    }

    public void update() {
        fishFacade.update();
        collisionUpdate();
    }

    public void collisionUpdate(){
        for(Fish i : getFishes()) {
            if (Utils.collides(i, hook)) {
                i.setTextureWhite();
            }
        }
    }

    public void createUser(String username){
        user = new User(username);
        System.out.print(user.getUsername() + " is created!");

    }

    public User getUser(){
        return user;
    }

    public void subscribeToLives(LifeObserver observer) {
        user.observeLife(observer);
    }

    public Hook getHookObject(){
        return hook;
    }

    public List<Fish> getFishes() {
        return fishFacade.getFishes();
    }

    public void subscribeToScores(ScoreObserver observer) {
        user.observeScore(observer);
    }

    public String getSpecificAnswer(int integer){
        return QL.getSpecificAnswer(integer);
    }

    public String getQuestion(){
        return QL.getQuestion();
    }

    public Set<String> getAnswers(){
        return QL.getAnswers();
    }

    public String getRightAnswer(){
        return QL.getRightAnswer();

    }

}
