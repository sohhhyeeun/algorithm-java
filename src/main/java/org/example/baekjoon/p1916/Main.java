package org.example.baekjoon.p1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class BusRoute implements Comparable<BusRoute> {
    int city;
    int cost;

    public BusRoute(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    @Override
    public int compareTo(BusRoute o) {
        return this.cost - o.cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수

        int[][] costList = new int[N + 1][N + 1]; // 요금표
        for(int n = 1; n <= N; n++) {
            Arrays.fill(costList[n], Integer.MAX_VALUE);
        }

        StringTokenizer st;
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(st.nextToken()); // 출발지의 도시 번호
            int destination = Integer.parseInt(st.nextToken()); // 도착지의 도시 번호
            int cost = Integer.parseInt(st.nextToken()); // 비용

            // 요금표의 요금을 최소 비용으로 개정
            costList[departure][destination] = Math.min(costList[departure][destination], cost);
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 출발점
        int end = Integer.parseInt(st.nextToken()); // 도착점

        int[] minCost = new int[N + 1]; // 출발점에서 각 도시까지의 최소 비용을 기록
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[start] = 0;

        PriorityQueue<BusRoute> pq = new PriorityQueue<>();
        pq.offer(new BusRoute(start, 0));

        while (!pq.isEmpty()) {
            BusRoute current = pq.poll();
            int currentCity = current.city;
            int currentCost = current.cost;

            if (minCost[currentCity] < currentCost) {
                continue;
            }

            // 현재 도시에서 갈 수 있는 다음 도시들 탐색
            for (int nextCity = 1; nextCity <= N; nextCity++) {
                // 다음 도시로 가는 버스 노선이 존재하는 경우
                if (costList[currentCity][nextCity] != Integer.MAX_VALUE) {
                    int newCost = currentCost + costList[currentCity][nextCity];

                    if (newCost < minCost[nextCity]) {
                        minCost[nextCity] = newCost;
                        pq.offer(new BusRoute(nextCity, newCost));
                    }
                }
            }
        }

        System.out.println(minCost[end]);
    }
}
