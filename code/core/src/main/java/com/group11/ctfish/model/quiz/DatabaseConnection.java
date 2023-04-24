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

    private String jsonFileName;

    /**
     * Default constructor
     * @param jsonFileName
     */
    public DatabaseConnection(String jsonFileName) {
        this.jsonFileName = "../core/src/main/resources/questions/" + jsonFileName;
    }

    /**
     * Only to be used for testing purposes
     */
    private DatabaseConnection() {}

    static DatabaseConnection getTestInstance(String jsonFileName) {
        DatabaseConnection testInstance = new DatabaseConnection();
        testInstance.jsonFileName = "../core/src/test/resources/questions/" + jsonFileName;
        return testInstance;
    }

    void setCompletePath(String path) {
        jsonFileName = path;
    }

    public Question[] readQuestions() throws IOException{
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

    public void writeQuestion(String question, Map<String, Boolean> answerMap) throws IOException {
        writeQuestion(new Question(question, answerMap));
    }

    public void writeQuestion(Question question) throws IOException {
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

    public void writeQuestion(JSONObject question) throws IOException{
        String jsonFileContent = readJsonFile();

        JSONArray jsonArray = new JSONArray(jsonFileContent);
        jsonArray.put(question);

        try (FileWriter fileWriter = new FileWriter(jsonFileName)) {
            fileWriter.write(jsonArray.toString());
        }
    }

    private String readJsonFile() throws IOException {
        Path path = Paths.get(jsonFileName);
        byte[] bytes = Files.readAllBytes(path);

        return new String(bytes, StandardCharsets.UTF_8);
    }
}
