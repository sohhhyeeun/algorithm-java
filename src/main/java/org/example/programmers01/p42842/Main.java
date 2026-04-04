package org.example.programmers01.p42842;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;

        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(brown, yellow)));
    }

    public int[] solution(int brown, int yellow) {
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int height = i;
                int width = yellow / i;

                if ((width + height) * 2 + 4 == brown) {
                    return new int[]{width + 2, height + 2};
                }
            }
        }

        return new int[]{0, 0};
    }
}
