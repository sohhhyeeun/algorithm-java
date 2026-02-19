package org.example.baekjoon.p1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[][] shortcuts = new int[N][3];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            shortcuts[n][0] = Integer.parseInt(st.nextToken());
            shortcuts[n][1] = Integer.parseInt(st.nextToken());
            shortcuts[n][2] = Integer.parseInt(st.nextToken());
        }

        int[] minDistance = new int[D + 1];
        Arrays.fill(minDistance, Integer.MAX_VALUE);
        minDistance[0] = 0;

        for (int d = 0; d <= D; d++) {
            if (d > 0) {
                minDistance[d] = Math.min(minDistance[d], minDistance[d - 1] + 1);
            }

            for (int n = 0; n < N; n++) {
                int start = shortcuts[n][0];
                int end = shortcuts[n][1];
                int distance = shortcuts[n][2];

                if (start == d && end <= D) {
                    minDistance[end] = Math.min(minDistance[end], minDistance[d] + distance);
                }
            }
        }

        System.out.println(minDistance[D]);
    }
}
