package org.example.programmers.p42748;

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

        for (int c = 0; c < commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            int[] part = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(part);
            answer[c] = part[k - 1];
        }

        return answer;
    }
}