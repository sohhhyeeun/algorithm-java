package org.example.baekjoon.p14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] room;
    static int count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                room[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);

        System.out.println(count);
    }

    private static void clean(int r, int c, int d) {
        if (room[r][c] == 0) {
            room[r][c] = 2;
            count++;
        }

        for (int i = 0; i < 4; i++) { // 현재 칸의 주변 4칸 청소 여부 확인
            d = (d + 3) % 4; // 현재 방향 기준 왼쪽으로 회전

            int nx = r + dx[d];
            int ny = c + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (room[nx][ny] == 0) {
                    clean(nx, ny, d);
                    return;
                }
            }
        }

        // 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
        int bx = r - dx[d];
        int by = c - dy[d];

        // 후진
        if (room[bx][by] != 1) {
            clean(bx, by, d);
        }
    }
}
