package org.example.programmers.p42840;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] answers = {1, 3, 2, 4, 2};

        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(answers)));
    }

    public int[][] student = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] scores = new int[3];
        for (int i = 0; i < 3; i++) {
            scores[i] = calculate(answers, i);
        }

        int maxScore = scores[0];
        for (int j = 1; j < scores.length; j++) {
            if (maxScore < scores[j]) {
                maxScore = scores[j];
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int m = 0; m < scores.length; m++) {
            if (scores[m] == maxScore) {
                list.add(m + 1);
            }
        }

        answer = new int[list.size()];
        for (int n = 0; n < list.size(); n++) {
            answer[n] = list.get(n);
        }

        return answer;
    }

    private int calculate(int[] answers, int studentNum) {
        int score = 0;

        for (int i = 0; i < answers.length; i++) {
            int n = i % student[studentNum].length;

            if (answers[i] == student[studentNum][n]) {
                score++;
            }
        }

        return score;
    }
}
