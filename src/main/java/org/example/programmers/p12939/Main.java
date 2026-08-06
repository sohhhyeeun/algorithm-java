package org.example.programmers.p12939;

public class Main {
    public static void main(String[] args) {
        String s = "-1 -2 -3 -4";

        Main T = new Main();

        System.out.println(T.solution(s));
    }

    public String solution(String s) {
        String[] arr = s.split(" ");

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);

            if (num < min) min = num;
            if (num > max) max = num;
        }

        return String.format("%d %d", min, max);
    }
}
