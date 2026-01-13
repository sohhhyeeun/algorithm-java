package org.example.programmers.p1844;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        System.out.println(solution(maps));
    }

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int solution(int[][] maps) {
        int answer = 0;

        int[] start = {0, 0};
        int[] end = {maps.length - 1, maps[0].length - 1};

        bfs(maps, start, end);

        answer = maps[end[0]][end[1]];

        if (answer == 1) {
            return -1;
        } else {
            return answer;
        }
    }

    public static void bfs(int[][] maps, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start); //성공 시 true, 실패 시 false 반환

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1) { //게임 맵을 벗어난 길인지
                    continue;
                }

                if (maps[nx][ny] != 1) { //벽으로 막혀있어 갈 수 없는 길인지, 이미 지나간 길인지
                    continue;
                }

                maps[nx][ny] = maps[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }
    }
}
