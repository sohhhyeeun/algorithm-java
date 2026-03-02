package org.example.programmers.p176963;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};

        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(name, yearning, photo)));
    }

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int score = 0;

            for (int j = 0; j < photo[i].length; j++) {
                score += map.getOrDefault(photo[i][j], 0);
            }

            answer[i] = score;
        }

        return answer;
    }
}
