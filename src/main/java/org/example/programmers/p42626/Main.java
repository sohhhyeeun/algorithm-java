package org.example.programmers.p42626;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int result = T.solution(scoville, K);

        System.out.println(result);
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.peek() < K) {
            if (pq.size() <= 1) {
                return -1;
            }

            int first = pq.poll();
            int second = pq.poll();

            int mixed = first + (second * 2);
            pq.offer(mixed);

            answer++;
        }

        return answer;
    }
}
