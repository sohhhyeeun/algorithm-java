package org.example.baekjoon.p2667;

import java.util.*;

public class Main {
    static int N;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        maps = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                maps[i][j] = line.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(i, j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int count : list) {
            System.out.println(count);
        }
    }

    private static int bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        visited[i][j] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll(); //현재 위치
            int curX = cur[0];
            int curY = cur[1];

            for (int k = 0; k < 4; k++) { //상하좌우
                int nx = curX + dx[k];
                int ny = curY + dy[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
