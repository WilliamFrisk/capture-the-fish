package com.group11.ctfish.model.quiz;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class DatabaseConnection {

    public static Question readQuestion() {
        return null; //TODO
    }

    public static void writeQuestion(String question, Map<String, Boolean> answerMap) {
        writeQuestion(new Question(question, answerMap));
    }

    public static void writeQuestion(Question question) {
        JSONObject questionObject = new JSONObject();
        questionObject.put("question", question.getQuestion());

        JSONArray answerArray = new JSONArray();

        for (String ans :
                question.getAnswerMap().keySet()) {
            JSONObject answer = new JSONObject();
            answer.put("answer", ans);
            answer.put("isCorrect", question.getAnswerMap().get(ans));
            answerArray.put(answer);
        }

        questionObject.put("options", answerArray);

        writeQuestion(questionObject);
    }

    public static void writeQuestion(JSONObject question) {
        try {
            Path path = Paths.get("../core/src/com/group11/ctfish/model/quiz/json-database/test.json");
            byte[] bytes = Files.readAllBytes(path);
            String jsonFileContent = new String(bytes, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(jsonFileContent);
            jsonArray.put(question);

            try (FileWriter fileWriter = new FileWriter("../core/src/com/group11/ctfish/model/quiz/json-database/test.json")) {
                fileWriter.write(jsonArray.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
