package org.example.programmers.p43238;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};

        Main T = new Main();

        System.out.println(T.solution(n, times));
    }

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long min = 1;
        long max = (long) times[times.length - 1] * n;
        long answer = max;

        while (min <= max) {
            long mid = min + (max - min) / 2;
            long count = 0;

            for (int time : times) {
                count += mid / time;
            }

            if (count >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }
}
