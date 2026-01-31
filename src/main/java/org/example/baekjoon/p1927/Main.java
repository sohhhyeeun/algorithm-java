package org.example.baekjoon.p1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐
        StringBuilder sb = new StringBuilder(); // 출력 결과 임시 저장
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(pq.poll()).append('\n'); // poll(): 값 출력 후 제거, peek(): 값 출력
                }
            } else {
                pq.add(x); //값 추가
            }
        }

        System.out.println(sb);
    }
}
