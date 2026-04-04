package org.example.programmers01.p87946;

public class Main {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        Main T = new Main();

        System.out.println(T.solution(k, dungeons));
    }

    public int maxCount = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        dfs(k, dungeons, 0, visited);

        return maxCount;
    }

    private void dfs(int remaining, int[][] dungeons, int count, boolean[] visited) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && remaining >= dungeons[i][0]) {
                visited[i] = true;
                dfs(remaining - dungeons[i][1], dungeons, count + 1, visited);
                visited[i] = false;
            }
        }
    }
}
