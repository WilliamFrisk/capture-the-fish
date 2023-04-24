package com.group11.ctfish.model.quiz;

import java.util.Map;
import java.util.Set;

public class Question {
    private final String question;
    private final Map<String, Boolean> answers;

    public Question(String question, Map<String, Boolean> answers) {
        this.question = question;
        checkCorrectAnswerInput(answers);
        this.answers = answers;
    }

    public String getQuestion() {
        return question;
    }

    public Set<String> getAnswers() {
        return answers.keySet();
    }

    public Map<String, Boolean> getAnswerMap() {
        return answers;
    }

    public String getCorrectAnswer() {
        for (String ans : answers.keySet()) {
            if (answers.get(ans)) {
                return ans;
            }
        }
        return null;
    }

    private void checkCorrectAnswerInput(Map<String, Boolean> input) throws IllegalArgumentException {
        if (input.size() != 4 || !input.containsValue(true)) {
            throw new IllegalArgumentException();
        }
    }
}
