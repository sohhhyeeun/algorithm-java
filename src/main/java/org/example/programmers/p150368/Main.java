package org.example.programmers.p150368;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};

        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(users, emoticons)));
    }

    public int[] discountSetup = {10, 20, 30, 40};
    public int maxMember;
    public int maxTotalCost;

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        int[] discountRate = new int[emoticons.length];
        maxMember = 0;
        maxTotalCost = 0;

        dfs(discountRate, 0, users, emoticons);

        answer[0] = maxMember;
        answer[1] = maxTotalCost;

        return answer;
    }

    private void dfs(int[] discountRate, int index, int[][] users, int[] emoticons) {
        if (index == discountRate.length) {
            int member = 0;
            int totalCost = 0;

            for (int i = 0; i < users.length; i++) {
                int cost = 0;

                for (int j = 0; j < emoticons.length; j++) {
                    if (users[i][0] <= discountRate[j]) {
                        int discountedPrice = emoticons[j] * (100 - discountRate[j]) / 100;

                        cost += discountedPrice;
                    }
                }

                if (users[i][1] <= cost) {
                    member++;
                } else {
                    totalCost += cost;
                }
            }

            if (maxMember < member) {
                maxMember = member;
                maxTotalCost = totalCost;
            } else if (maxMember == member) {
                if (maxTotalCost < totalCost) {
                    maxTotalCost = totalCost;
                }
            }

            return;
        }

        for (int i = 0; i < discountSetup.length; i++) {
            discountRate[index] = discountSetup[i];

            dfs(discountRate, index + 1, users, emoticons);
        }
    }
}
