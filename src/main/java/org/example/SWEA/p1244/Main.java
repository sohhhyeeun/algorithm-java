package org.example.SWEA.p1244;

import java.util.Scanner;

public class Main {
    static int answer;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            String num;
            num = sc.next();
            int exchg;
            exchg = sc.nextInt();

            int N = num.length();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = num.charAt(i) - '0';
            }

            answer = 0;
            visited = new boolean[exchg + 1][1000000];
            DFS(0, nums, exchg);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static void DFS(int currentExchg, int[] nums, int exchg) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = result * 10 + nums[i];
        }

        if (visited[currentExchg][result]) {
            return;
        }

        visited[currentExchg][result] = true;

        if (currentExchg == exchg) {
            answer = Math.max(answer, result);

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int M = nums[i];
                nums[i] = nums[j];
                nums[j] = M;

                DFS(currentExchg + 1, nums, exchg);

                M = nums[j];
                nums[j] = nums[i];
                nums[i] = M;
            }
        }
    }
}
