package org.example.baekjoon.p1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        int[] time = new int[100001];
        Arrays.fill(time, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        time[N] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                System.out.println(time[current]);
                return;
            }

            int[] nexts = {current - 1, current + 1, current * 2};

            for (int next : nexts) {
                if (next >= 0 && next <= 100000 && time[next] == -1) {
                    time[next] = time[current] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}
