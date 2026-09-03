package org.example.programmers02.p42576;

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

        for (int i = 0; i < participant.length; i++) {
            hashMap.put(participant[i], hashMap.getOrDefault(participant[i], 0) + 1);
        }

        for (int j = 0; j < completion.length; j++) {
            hashMap.put(completion[j], hashMap.get(completion[j]) - 1);
        }

        for (String key : hashMap.keySet()) {
            if (hashMap.get(key) > 0) {
                answer = key;
            }
        }

        return answer;
    }
}
