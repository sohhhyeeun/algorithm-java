package org.example.programmers01.p43162;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        };

        Main T = new Main();

        System.out.println(T.solution(n, computers));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(n, computers, i, visited);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int n, int[][] computers, int index, boolean[] visited) {
        visited[index] = true;

        for (int i = 0; i < n; i++) {
            if (computers[index][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(n, computers, i, visited);
            }
        }
    }
}
