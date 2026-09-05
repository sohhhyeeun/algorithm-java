package org.example.programmers01.p1844;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] maps = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        Main T = new Main();

        System.out.println(T.solution(maps));
    }

    int[] dx = {0, 1, 0, -1};
    int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        bfs(maps, n, m, visited, 0, 0);

        answer = maps[n - 1][m - 1];
        if (answer == 1) {
            return -1;
        } else {
            return answer;
        }
    }

    private void bfs(int[][] maps, int n, int m, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[cx][cy] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
