package org.example.baekjoon.p2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int computerNum;
    static int pairNum;
    static int[][] network;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        computerNum = sc.nextInt();
        pairNum = sc.nextInt();

        network = new int[computerNum + 1][computerNum + 1];

        for (int i = 0; i < pairNum; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            network[a][b] = 1;
            network[b][a] = 1;
        }

        visited = new boolean[computerNum + 1];

        int result = bfs(1);

        System.out.println(result);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= computerNum; i++) {
                if (network[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
