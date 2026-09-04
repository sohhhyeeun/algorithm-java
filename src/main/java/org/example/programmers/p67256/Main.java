package org.example.programmers.p67256;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";

        Main T = new Main();

        System.out.println(T.solution(numbers, hand));
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";

        int[] leftStart = {3, 0};
        int[] rightStart = {3, 2};

        int[][] coord = {
                {3, 1},
                {0, 0}, {0, 1}, {0, 2},
                {1, 0}, {1, 1}, {1, 2},
                {2, 0}, {2, 1}, {2, 2}
        };

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                leftStart = coord[numbers[i]];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                rightStart = coord[numbers[i]];
            } else {
                int distanceFromLeft = Math.abs(leftStart[0] - coord[numbers[i]][0]) + Math.abs(leftStart[1] - coord[numbers[i]][1]);
                int distanceFromRight = Math.abs(rightStart[0] - coord[numbers[i]][0]) + Math.abs(rightStart[1] - coord[numbers[i]][1]);

                if (distanceFromLeft < distanceFromRight) {
                    answer += "L";
                    leftStart = coord[numbers[i]];
                } else if (distanceFromLeft > distanceFromRight) {
                    answer += "R";
                    rightStart = coord[numbers[i]];
                } else {
                    if (hand.equals("left")) {
                        answer += "L";
                        leftStart = coord[numbers[i]];
                    } else if (hand.equals("right")) {
                        answer += "R";
                        rightStart = coord[numbers[i]];
                    }
                }
            }
        }

        return answer;
    }
}
