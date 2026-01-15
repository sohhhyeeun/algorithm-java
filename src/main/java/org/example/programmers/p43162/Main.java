package org.example.programmers.p43162;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, visited, n, computers);
                answer++;
            }
        }

        return answer;
    }

    private static void bfs(int start, boolean[] visited, int n, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < n; i++) {
                if (computers[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
