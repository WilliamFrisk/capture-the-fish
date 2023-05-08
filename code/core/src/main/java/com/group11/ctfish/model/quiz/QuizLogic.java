package com.group11.ctfish.model.quiz;
import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.user.User;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class QuizLogic {

    private final DatabaseConnection db = new DatabaseConnection("questions.json");
    private int index = randomizeNumber();
    private Question[] questions;
    private Question currentQuestion;
    private boolean rightAnswer;

    private final ModelFacade facade;


    public QuizLogic(ModelFacade facade) {
        this.facade = facade;

        try {
            questions = db.readQuestions();
            currentQuestion = questions[index];
            rightAnswer = false;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int randomizeNumber(){
        Random r = new Random();
        int low = 0;
        int high = 9;
        return r.nextInt(high-low) + low;
    }

    public String getQuestion(){
        return currentQuestion.getQuestion();
    }

    public Set<String> getAnswers(){
        return currentQuestion.getAnswers();
    }

    public String getSpecificAnswer(int num){
        int iterator = 1;
        for (String ans : getAnswers()) {
            if (num == iterator) {
                return ans;
            }
            iterator += 1;
        }
        return null;
    }

    public String getRightAnswer(){
        return currentQuestion.getCorrectAnswer();

    }

    public void addLives(String answer){
        if (Objects.equals(getRightAnswer(), answer) && facade.getUser().getLives() < 3){
            facade.getUser().addLife();
            System.out.println("RIGHT ANSWER");
            rightAnswer = true;
        }
    }

    public boolean getAnswerBoolean(){
        return rightAnswer;
    }

    public void moveToNextQuestion(){
        try {
            rightAnswer = false;
            currentQuestion = questions[index];
            index++;
        }
        catch (IndexOutOfBoundsException e){
            index = 0;
        }
    }


}

