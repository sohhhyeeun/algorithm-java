package org.example.programmers.p12945;

public class Main {
    public static void main(String[] args) {
        int n = 5;

        Main T = new Main();

        System.out.println(T.solution(n));
    }

    public int solution(int n) {
        int[] fibo = new int[n + 1];

        fibo[0] = 0;
        fibo[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1234567;
        }

        return fibo[n];
    }
}
