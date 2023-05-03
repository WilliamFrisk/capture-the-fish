package com.group11.ctfish.model;

import com.group11.ctfish.model.fish.Fish;

import com.group11.ctfish.model.quiz.QuizLogic;

import com.group11.ctfish.model.fish.FishFacade;
import com.group11.ctfish.model.user.ScoreObserver;
import com.group11.ctfish.model.util.Utils;


import java.util.ArrayList;

import com.group11.ctfish.model.user.User;
import com.group11.ctfish.view.FishingScreen;


import java.util.List;

import java.util.Set;
import java.util.Random;

public class ModelFacade {
    private List<Fish> fishList;

    User user;
    private static ModelFacade instance = new ModelFacade();

    QuizLogic QL = new QuizLogic();

    Hook hook = new Hook();

    private static final int TOTAL_FISHES = 15;
    private static final int TIME_DIFFERENCE = 250;
    Random rand = new Random();

    private ModelFacade (){
        this.fishList = new ArrayList<>();
    }

    public static ModelFacade getInstance(){
        return instance;
    }

    public void CollisionUpdate(){
        for(Fish i : getFishList()) {
            if (Utils.collides(i, hook)) {
                i.setTextureWhite();
            }
        }
    }

    public void createUser(String username){
        user = new User(username);
        System.out.print(user.getUsername() + " is created!");
    }

    public Hook getHookObject(){
        return hook;
    }

    public List<Fish> getFishList() {
        return FishFacade.getInstance().getFishes();
    }


    public void subscribeToScores(ScoreObserver observer) {
        user.observeScore(observer);

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
