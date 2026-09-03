package org.example.programmers01.p42578;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        Main T = new Main();

        System.out.println(T.solution(clothes));
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            hashMap.put(clothes[i][1], hashMap.getOrDefault(clothes[i][1], 1) + 1);
        }

        for (int value : hashMap.values()) {
            answer *= value;
        }

        return answer - 1;
    }
}
