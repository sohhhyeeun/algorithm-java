package org.example.programmers01.p43165;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        Main T = new Main();

        System.out.println(T.solution(numbers, target));
    }

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);

        return answer;
    }

    private void dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }

            return;
        }

        dfs(numbers, target, index + 1, sum + numbers[index]);

        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
