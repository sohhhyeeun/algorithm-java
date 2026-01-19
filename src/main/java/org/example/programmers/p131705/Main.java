package org.example.programmers.p131705;

public class Main {
    public static void main(String[] args) {
        int[] number = {-3, -2, -1, 0, 1, 2, 3};

        System.out.println(solution(number));
    }

    public static int solution(int[] number) {
        int answer = 0;

        int n = number.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
