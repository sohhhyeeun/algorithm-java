package org.example.baekjoon.p7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M, N;
    static int[][] maps;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        maps = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maps[i][j] = sc.nextInt();

                if (maps[i][j] == 1) { //동시 시작
                    queue.offer(new int[]{i, j});
                }
            }
        }

        bfs();

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 0) { //토마토가 모두 익지 못하는 상황
                    System.out.println(-1);
                    return;
                }
                if (maps[i][j] > result) { //마지막에 익은 토마토의 일수
                    result = maps[i][j];
                }
            }
        }

        System.out.println(result - 1);
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int dirs = 0; dirs < 4; dirs++) {
                int nx = curX + dx[dirs];
                int ny = curY + dy[dirs];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (maps[nx][ny] == 0) {
                        queue.offer(new int[]{nx, ny});
                        maps[nx][ny] = maps[curX][curY] + 1;
                    }
                }
            }
        }
    }
}
