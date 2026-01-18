package org.example.programmers.p154538;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;

        System.out.println(solution(x, y, n));
    }

    public static int solution(int x, int y, int n) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, 0});

        boolean[] visited = new boolean[y + 1];
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int currentNum = cur[0];
            answer = cur[1];

            if (currentNum == y) {
                return answer;
            }

            int[] nextNums = {currentNum + n, currentNum * 2, currentNum * 3};

            for (int nextNum : nextNums) {
                if (nextNum <= y && !visited[nextNum]) {
                    visited[nextNum] = true;
                    queue.offer(new int[]{nextNum, answer + 1});
                }
            }
        }

        return -1;
    }
}
