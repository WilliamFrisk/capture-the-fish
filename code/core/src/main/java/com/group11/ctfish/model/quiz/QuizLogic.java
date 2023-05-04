package com.group11.ctfish.model.quiz;
import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.user.User;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class QuizLogic {

    DatabaseConnection db = new DatabaseConnection("questions.json");
    int index = randomizeNumber();
    Question[] questions;
    Question currentQuestion;
    boolean rightAnswer;

    ModelFacade facade;
    User currentUser;

    public QuizLogic(ModelFacade facade) {
        try {
            this.facade = facade;
            currentUser = facade.getUser();
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
        int result = r.nextInt(high-low) + low;

        return result;
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
        currentUser = facade.getUser();
        if (Objects.equals(getRightAnswer(), answer) && currentUser.getLives() < 3){
            currentUser.addLife();
            System.out.println("RIGHT ANSWER");
            rightAnswer = true;

        }
    }

    public boolean getAnswerBoolean(){return rightAnswer;}

    public void moveToNextQuestion(){
        try {
            index++;
            currentQuestion = questions[index];
            rightAnswer = false;
        }
        catch (IndexOutOfBoundsException e){
            index = 0;
        }
    }


}

