package com.group11.ctfish.model.quiz;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DatabaseConnection {

    private static final String JSON_FILE_NAME = "questions.json";

    public static Question[] readQuestions() throws IOException{
        String jsonFileContent = readJsonFile();
        JSONArray jsonArray = new JSONArray(jsonFileContent);

        Question[] result = new Question[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            Object obj = jsonArray.get(i);
            if (obj instanceof JSONObject) {
                JSONObject jsonObj = (JSONObject) obj;

                String q = jsonObj.getString("question");
                Map<String, Boolean> aMap = new HashMap<>();

                for (Object option : jsonObj.getJSONArray("options")) {
                    if (option instanceof JSONObject) {
                        JSONObject jsonOption = (JSONObject) option;

                        aMap.put(jsonOption.getString("answer"), jsonOption.getBoolean("isCorrect"));
                    }
                }

                result[i] = new Question(q, aMap);
            }
        }

        return result;
    }

    public static void writeQuestion(String question, Map<String, Boolean> answerMap) throws IOException {
        writeQuestion(new Question(question, answerMap));
    }

    public static void writeQuestion(Question question) throws IOException {
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
    
    public static void writeQuestion(JSONObject question) throws IOException{
        String jsonFileContent = readJsonFile();

        JSONArray jsonArray = new JSONArray(jsonFileContent);
        jsonArray.put(question);

        try (FileWriter fileWriter = new FileWriter("../core/src/com/group11/ctfish/model/quiz/json-database/" + JSON_FILE_NAME)) {
            fileWriter.write(jsonArray.toString());
        }
    }

    private static String readJsonFile() throws IOException {
        Path path = Paths.get("../core/src/com/group11/ctfish/model/quiz/json-database/" + JSON_FILE_NAME);
        byte[] bytes = Files.readAllBytes(path);

        return new String(bytes, StandardCharsets.UTF_8);
    }
}
