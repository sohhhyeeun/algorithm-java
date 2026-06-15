package org.example.programmers.p68644;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 0, 2, 7};

        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(numbers)));
    }

    public int[] solution(int[] numbers) {
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                hashSet.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[hashSet.size()];

        int index = 0;
        for (int i : hashSet) {
            answer[index++] = i;
        }

        Arrays.sort(answer);

        return answer;
    }
}
