package org.example.baekjoon.p1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] sequence;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sequence = new int[N];
        for (int n = 0; n < N; n++) {
            sequence[n] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0) {
            answer--;
        }

        System.out.println(answer);
    }

    public static void dfs(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                answer++;
            }

            return;
        }

        dfs(index + 1, sum + sequence[index]);
        dfs(index + 1, sum);
    }
}
