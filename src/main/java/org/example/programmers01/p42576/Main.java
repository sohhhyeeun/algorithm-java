package org.example.programmers01.p42576;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Main T = new Main();

        System.out.println(T.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String p : participant) {
            hashMap.put(p, hashMap.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            hashMap.put(c, hashMap.get(c) - 1);
        }

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) > 0) {
                answer = key;
            }
        }

        return answer;
    }
}
