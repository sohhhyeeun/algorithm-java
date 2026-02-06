package org.example.baekjoon.p3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[][] board;
    static HashMap<Integer, String> directInfo;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int appleX = Integer.parseInt(st.nextToken());
            int appleY = Integer.parseInt(st.nextToken());

            board[appleX - 1][appleY - 1] = 1;
        }

        int L = Integer.parseInt(br.readLine());

        directInfo = new HashMap<>();
        for (int l = 0; l < L; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();

            directInfo.put(X, C);
        }

        int result = crawl(0, 0);

        System.out.println(result);
    }

    private static int crawl(int x, int y) {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[]{x, y});
        board[x][y] = 2;

        int time = 0;
        int d = 0;
        while (true) {
            time++;

            // 다음 뱀 머리의 위치
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 벽이나 자기자신의 몸과 부딪히면, 게임 끝
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 2) {
                return time;
            }

            snake.offer(new int[]{nx, ny});
            // 이동한 칸에 사과가 없다면, 꼬리가 위치한 칸을 비워 몸 길이 유지
            if (board[nx][ny] != 1) {
                int[] tail = snake.poll(); // 꼬리가 위치한 칸
                board[tail[0]][tail[1]] = 0;
            }
            board[nx][ny] = 2;

            // 뱀의 방향 변환
            if (directInfo.containsKey(time)) {
                String direction = directInfo.get(time);
                if (direction.equals("L")) { // 왼쪽
                    d = (d - 1 + 4) % 4;
                } else if (direction.equals("D")) { // 오른쪽
                    d = (d + 1) % 4;
                }
            }

            // 좌표 갱신
            x = nx;
            y = ny;
        }
    }
}
