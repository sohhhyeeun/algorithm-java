package org.example.programmers.p12906;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(arr)));
    }

    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int a : arr) {
            if (stack.isEmpty() || stack.peek() != a) {
                stack.push(a);
            }
        }

        int[] answer = new int[stack.size()];

        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}
