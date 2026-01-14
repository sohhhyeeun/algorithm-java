package org.example.programmers.p154540;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};

        System.out.println(Arrays.toString(solution(maps)));
    }

    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static int[] solution(String[] maps) {
        int[] answer = {};

        int rows = maps.length;
        int cols = maps[0].length();
        int[][] intMaps = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = maps[i].charAt(j);

                if (c == 'X') {
                    intMaps[i][j] = -1;
                } else {
                    intMaps[i][j] = c - '0';
                }
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (intMaps[i][j] > 0) {
                    list.add(bfs(intMaps, i, j));
                }
            }
        }

        if (list.isEmpty()) {
            answer = new int[]{-1};
        } else {
            Collections.sort(list);

            answer = new int[list.size()];

            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
        }

        return answer;
    }

    private static int bfs(int[][] intMaps, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        int sum = intMaps[i][j];
        intMaps[i][j] = -1; //visited

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx > intMaps.length - 1 || ny < 0 || ny > intMaps[0].length - 1) {
                    continue;
                }

                if (intMaps[nx][ny] == -1) {
                    continue;
                }

                sum += intMaps[nx][ny];
                intMaps[nx][ny] = -1;
                queue.offer(new int[]{nx, ny});
            }
        }

        return sum;
    }
}
