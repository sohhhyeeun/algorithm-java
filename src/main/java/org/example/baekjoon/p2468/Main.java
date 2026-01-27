package org.example.baekjoon.p2468;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] zone;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        zone = new int[N][N];
        int maxHeight = 0; //최대 높이
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                zone[i][j] = sc.nextInt();
                
                if (zone[i][j] > maxHeight) {
                    maxHeight = zone[i][j];
                }
            }
        }

        int maxSafeZone = 0; //안전한 영역의 최대 개수

        for (int h = 0; h < maxHeight; h++) {
            visited = new boolean[N][N];
            int countSafeZone = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (zone[i][j] > h && !visited[i][j]) {
                        bfs(i, j, h);
                        countSafeZone++;
                    }
                }
            }

            maxSafeZone = Math.max(maxSafeZone, countSafeZone); //안전한 영역의 최대 개수 갱신
        }

        System.out.println(maxSafeZone);
    }

    private static void bfs(int i, int j, int h) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = curX + dx[k];
                int ny = curY + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (zone[nx][ny] > h && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
