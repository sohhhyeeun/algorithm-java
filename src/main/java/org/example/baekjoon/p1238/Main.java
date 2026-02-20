package org.example.baekjoon.p1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // input = 4, 1번 마을 ~ 4번 마을
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()); // input = 2, 파티 마을

        int[][] map = new int[N + 1][N + 1];
        int[][] reverseMap = new int[N + 1][N + 1];
        for(int n = 1; n <= N; n++) {
            Arrays.fill(map[n], Integer.MAX_VALUE);
            Arrays.fill(reverseMap[n], Integer.MAX_VALUE);
            map[n][n] = 0;
            reverseMap[n][n] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            map[start][end] = Math.min(map[start][end], T);
            reverseMap[end][start] = Math.min(reverseMap[end][start], T);
        }

        int[] toHome = dijkstra(X, map, N); // X에서 집으로
        int[] toParty = dijkstra(X, reverseMap, N); // 집에서 X로

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            int roundTripTime = toParty[i] + toHome[i];

            maxTime = Math.max(maxTime, roundTripTime);
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(int start, int[][] map, int N) {
        int[] timeRecord = new int[N + 1];
        Arrays.fill(timeRecord, Integer.MAX_VALUE);
        timeRecord[start] = 0;

        Comparator<int[]> timeComparator = (o1, o2) -> o1[1] - o2[1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(timeComparator);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentVillage = current[0];
            int accumulatedTime = current[1];

            if (accumulatedTime > timeRecord[currentVillage]) {
                continue;
            }

            for (int nextVillage = 1; nextVillage <= N; nextVillage++) {
                if (map[currentVillage][nextVillage] != Integer.MAX_VALUE) {
                    int updateTime = accumulatedTime + map[currentVillage][nextVillage];

                    if (updateTime < timeRecord[nextVillage]) {
                        timeRecord[nextVillage] = updateTime;
                        pq.offer(new int[]{nextVillage, updateTime});
                    }
                }
            }
        }

        return timeRecord;
    }
}
