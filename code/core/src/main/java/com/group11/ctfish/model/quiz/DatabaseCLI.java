package com.group11.ctfish.model.quiz;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DatabaseCLI {

    private static final DatabaseConnection db = new DatabaseConnection("questions.json");

    public static void main(String[] args) {
        db.setCompletePath("../code/core/src/main/resources/questions/questions.json");
        run();
    }

    private static void run() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            Map<String, Boolean> answerMap = new HashMap<>();

            System.out.print("Enter the question: ");
            String question = sc.nextLine();

            System.out.print("Enter answer 1 (Correct Answer): ");
            answerMap.put(sc.nextLine(), true);

            System.out.print("Enter answer 2: ");
            answerMap.put(sc.nextLine(), false);

            System.out.print("Enter answer 3: ");
            answerMap.put(sc.nextLine(), false);

            System.out.print("Enter answer 4: ");
            answerMap.put(sc.nextLine(), false);

            try {
                db.writeQuestion(question, answerMap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
