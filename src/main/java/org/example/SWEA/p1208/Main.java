package org.example.SWEA.p1208;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int dump;
            dump = sc.nextInt();

            int[] height = new int[100];
            for (int i = 0; i < 100; i++) {
                height[i] = sc.nextInt();
            }

            Arrays.sort(height);

            for (int j = 0; j < dump; j++) {
                height[99]--;
                height[0]++;
                Arrays.sort(height);
            }

            int result = height[99] - height[0];

            System.out.println("#" + test_case + " " + result);
        }
    }
}
