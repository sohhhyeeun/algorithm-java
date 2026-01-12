package org.example.programmers.p43165;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        solution(numbers, target);
    }

    static int answer;

    public static int solution(int[] numbers, int target) {
        answer = 0;

        dfs(numbers, target, 0, 0);

        return answer;
    }

    private static void dfs(int[] numbers, int target, int index, int currentSum) {
        if (index == numbers.length) {
            if (currentSum == target) {
                answer++;
            }

            return;
        }

        int plusSum = currentSum + numbers[index];
        int minusSum = currentSum - numbers[index];

        dfs(numbers, target, index + 1, plusSum);
        dfs(numbers, target, index + 1, minusSum);
    }
}
