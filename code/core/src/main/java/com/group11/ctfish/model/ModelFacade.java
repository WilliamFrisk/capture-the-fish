package com.group11.ctfish.model;

import com.group11.ctfish.model.fish.Fish;
import com.group11.ctfish.model.fish.FishFacade;
import com.group11.ctfish.model.quiz.QuizLogic;
import com.group11.ctfish.model.user.LifeObserver;
import com.group11.ctfish.model.user.ScoreObserver;
import com.group11.ctfish.model.user.User;
import com.group11.ctfish.model.util.Utils;


import java.security.Key;
import java.util.List;

public class ModelFacade {

    private static final ModelFacade INSTANCE = new ModelFacade();


    private User user;
    private final QuizLogic QL;
    private final FishFacade fishFacade = FishFacade.getInstance();
    private final Hook hook = new Hook();



    private ModelFacade() {
        QL = new QuizLogic(this);
    }

    public static ModelFacade getInstance(){
        return INSTANCE;
    }


    public void update() {
        fishFacade.update();
        collisionUpdate();
    }

    public void collisionUpdate(){
        if (!hook.isFishOn()) {
            for(Fish fish : getFishes()) {
                if (Utils.collides(fish, hook)) {
                    hook.fishOn();
                    fish.followVector(hook.getVectorInstance());
                    break;
                }
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

    public void addLife(String answer){
        QL.addLives(answer);
    }

    public String getCorrectAnswer(){
        return QL.getRightAnswer();
    }

    public boolean getAnswerBoolean() { return QL.getAnswerBoolean();}

    public void moveToNextQuestion(){ QL.moveToNextQuestion(); }

    public void questionFishCaught(){ QL.questionFishCaught();}
    public boolean getFishBoolean(){ return QL.getFishBoolean();}

}
