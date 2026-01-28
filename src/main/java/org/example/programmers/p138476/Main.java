package org.example.programmers.p138476;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        //코드 작성 방향: 크기가 서로 다른 종류의 수를 최소로 하기 위해서는 귤의 개수가 많은 종류부터 상자에 담아야 한다.
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>(); //Key: 귤의 크기, Value: 해당 크기의 귤 개수
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1); 
            //map.getOrDefault(t, 0) + 1: 처음 등장하면 1(0 + 1), 이미 있으면 기존 개수 + 1
        }

        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder()); //내림차순 정렬

        for (int count : counts) {
            k -= count;
            answer++;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}
