package org.example.programmers.p42586;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(progresses, speeds)));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / (double) speeds[i]);

            if (!queue.isEmpty() && queue.peek() < days) {
                list.add(queue.size());
                queue.clear();
            }

            queue.offer(days);
        }

        if (!queue.isEmpty()) {
            list.add(queue.size());
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
