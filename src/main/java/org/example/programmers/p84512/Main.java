package org.example.programmers.p84512;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String word = "EIO";

        solution(word);
    }

    private static String[] alphabet = {"A", "E", "I", "O", "U"};
    private static int maxLength = 5;
    private static List<String> dictionary = new ArrayList<>();

    public static int solution(String word) {
        int answer = 0;

        dfs("");

        for (int i = 0; i < dictionary.size(); i++) {
            if (dictionary.get(i).equals(word)) {
                answer = i + 1;
            }
        }

        return answer;
    }

    private static void dfs(String currentWord) {
        if (!currentWord.isEmpty()) {
            dictionary.add(currentWord);
        }

        if (currentWord.length() == maxLength) {
            return;
        }

        for (int i = 0; i < alphabet.length; i++) {
            dfs(currentWord + alphabet[i]);
        }
    }
}
