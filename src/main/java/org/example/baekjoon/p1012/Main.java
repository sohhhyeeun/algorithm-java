package org.example.baekjoon.p1012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M, N, K;
    static int X, Y;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();

            maps = new int[N][M];

            for (int k = 0; k < K; k++) {
                X = sc.nextInt();
                Y = sc.nextInt();

                maps[Y][X] = 1; //maps[세로][가로]
            }

            visited = new boolean[N][M];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (maps[i][j] == 1 && !visited[i][j]) { //방문하지 않은 새로운 배추
                        bfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int dirs = 0; dirs < 4; dirs++) {
                int nx = curX + dx[dirs];
                int ny = curY + dy[dirs];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) { //상하좌우 배추 중 방문하지 않은 배추
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
