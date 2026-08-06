package org.example.programmers.p12909;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "(()(";

        Main T = new Main();

        System.out.println(T.solution(s));
    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
