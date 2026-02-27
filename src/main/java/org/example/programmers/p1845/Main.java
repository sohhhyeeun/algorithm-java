package org.example.programmers.p1845;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};

        Main T = new Main();

        System.out.println(T.solution(nums));
    }

    public int solution(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }

        int max = nums.length / 2;

        return Math.min(max, hashSet.size());
    }
}
