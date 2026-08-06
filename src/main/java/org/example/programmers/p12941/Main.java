package org.example.programmers.p12941;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {3, 4};

        Main T = new Main();

        System.out.println(T.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[(B.length - 1) - i];
        }

        return answer;
    }
}
