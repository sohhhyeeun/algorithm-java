package org.example.programmers01.p42748;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] result = T.solution(array, commands);

        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int l = 0; l < commands.length; l++) {
            int i = commands[l][0];
            int j = commands[l][1];
            int k = commands[l][2];

            int[] part = new int[j - i + 1];
            for (int p = 0; p < part.length; p++) {
                part[p] = array[i - 1];
                i++;
            }

            Arrays.sort(part);

            answer[l] = part[k - 1];
        }

        return answer;
    }
}
