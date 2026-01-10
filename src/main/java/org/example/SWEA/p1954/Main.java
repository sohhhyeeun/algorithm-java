package org.example.SWEA.p1954;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N;
            N = sc.nextInt();

            int[][] map = new int[N][N];

            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};

            int r = 0;
            int c = 0;
            int dir = 0;

            for (int i = 1; i <= N * N; i++) {
                map[r][c] = i;

                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0) {
                    dir = (dir + 1) % 4;

                    nr = r + dr[dir];
                    nc = c + dc[dir];
                }

                r = nr;
                c = nc;
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
