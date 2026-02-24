package org.example.programmers.p42578;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        Main T = new Main();

        System.out.println(T.solution(clothes));
    }

    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothesByCategory = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String category = clothes[i][1];

            clothesByCategory.put(category, clothesByCategory.getOrDefault(category, 0) + 1);
        }

        for (int number : clothesByCategory.values()) {
            answer *= (number + 1);
        }

        return answer - 1;
    }
}
