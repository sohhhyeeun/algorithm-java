package org.example.programmers.p42885;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] people = {70, 80, 50};
        int limit = 100;

        Main T = new Main();

        System.out.println(T.solution(people, limit));
    }

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }

            right--;
            answer++;
        }

        return answer;
    }
}
