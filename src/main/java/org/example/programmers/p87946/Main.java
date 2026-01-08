package org.example.programmers.p87946;

public class Main {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};

        solution(k, dungeons);
    }

    private static int maxDungeons = 0;

    public static int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] visited = new boolean[dungeons.length];

        dfs(k, 0, dungeons, visited);
        answer = maxDungeons;

        return answer;
    }

    public static void dfs(int currentK, int count, int[][] dungeons, boolean[] visited) {
        maxDungeons = Math.max(maxDungeons, count);

        for (int i = 0; i < dungeons.length; i++) {
            int minRequired = dungeons[i][0];
            int consume = dungeons[i][1];

            if (!visited[i] && currentK >= minRequired) {
                visited[i] = true;

                dfs(currentK - consume, count + 1, dungeons, visited);

                visited[i] = false;
            }
        }
    }
}
