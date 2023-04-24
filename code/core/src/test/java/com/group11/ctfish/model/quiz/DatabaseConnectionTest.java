package com.group11.ctfish.model.quiz;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class DatabaseConnectionTest {

    @BeforeClass
    public static void setup() {
        try (FileWriter fileWriter = new FileWriter("../core/src/test/resources/questions/empty.json")){
            fileWriter.write("[]");
        } catch (IOException e) {
           e.printStackTrace();
        }
    }

    @Test
    public void readQuestions() throws IOException {
        DatabaseConnection db = DatabaseConnection.getTestInstance("filled.json");
        Question[] questionArr = db.readQuestions();
        Question q = questionArr[0];

        Set<String> expectedAnswers = new HashSet<>();
        expectedAnswers.add("test1");
        expectedAnswers.add("test2");
        expectedAnswers.add("test3");
        expectedAnswers.add("test4");

        assertEquals("testQuestion", q.getQuestion());
        assertEquals("test1", q.getCorrectAnswer());
        assertEquals(expectedAnswers, q.getAnswers());
    }

    @Test
    public void writeQuestion() throws IOException {
        DatabaseConnection db = DatabaseConnection.getTestInstance("empty.json");

        Map<String, Boolean> answerMap = new HashMap<>();
        answerMap.put("test1", true);
        answerMap.put("test2", false);
        answerMap.put("test3", false);
        answerMap.put("test4", false);

        db.writeQuestion("testQuestion", answerMap);
        assertEquals(
                "[{\"question\":\"testQuestion\",\"options\":" +
                        "[{\"answer\":\"test4\",\"isCorrect\":false}," +
                        "{\"answer\":\"test2\",\"isCorrect\":false}," +
                        "{\"answer\":\"test3\",\"isCorrect\":false}," +
                        "{\"answer\":\"test1\",\"isCorrect\":true}]}]",
                        readJsonFile("empty.json")
                );
    }

    private static String readJsonFile(String jsonFileName) throws IOException {
        Path path = Paths.get("../core/src/test/resources/questions/" + jsonFileName);
        byte[] bytes = Files.readAllBytes(path);

        return new String(bytes, StandardCharsets.UTF_8);
    }
}