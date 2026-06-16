package org.example.programmers.p142086;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String s = "foobar";

        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(s)));
    }

    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                answer[i] = i - map.get(ch);
            } else {
                answer[i] = -1;
            }

            map.put(ch, i);
        }

        return answer;
    }
}
