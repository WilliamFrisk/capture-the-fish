package com.group11.ctfish.model.quiz;

import java.io.IOException;
import java.util.Random;
import java.util.Set;

public class QuizLogic {

    DatabaseConnection db = new DatabaseConnection("questions.json");
    int random = randomizeNumber();
    Question[] questions;
    Question currentQuestion;

    public QuizLogic() {
        try {
            questions = db.readQuestions();
            currentQuestion = questions[random];
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
}
