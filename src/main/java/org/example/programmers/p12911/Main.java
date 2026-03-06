package org.example.programmers.p12911;

public class Main {
    public static void main(String[] args) {
        int n = 15;

        Main T = new Main();

        System.out.println(T.solution(n));
    }

    public int solution(int n) {
        int count = Integer.bitCount(n);
        int next = n + 1;

        while (true) {
            if (Integer.bitCount(next) == count) {
                return next;
            }

            next++;
        }
    }
}
