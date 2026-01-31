package org.example.baekjoon.p14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxSafeZone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());

            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // 0: 빈 칸, 1: 벽, 2: 바이러스가 있는 곳
        // 새로 세울 수 있는 벽의 개수 = 3
        dfs(0);

        System.out.println(maxSafeZone);
    }

    static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            return;
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (map[n][m] == 0) {
                    map[n][m] = 1;
                    dfs(wall + 1);
                    map[n][m] = 0;
                }
            }
        }
    }

    static void bfs() {
        int[][] testMap = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                testMap[n][m] = map[n][m];
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (testMap[n][m] == 2) {
                    queue.offer(new int[]{n, m});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int dirs = 0; dirs < 4; dirs++) {
                int nx = curX + dx[dirs];
                int ny = curY + dy[dirs];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (testMap[nx][ny] == 0) {
                        testMap[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (testMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        if (safeZone > maxSafeZone) {
            maxSafeZone = safeZone;
        }
    }
}
