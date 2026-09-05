package org.example.programmers.p92334;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(id_list, report, k)));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Set<String>> deduplication = new HashMap<>();
        for (String id : id_list) {
            deduplication.put(id, new HashSet<>());
        }

        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] parts = report[i].split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            if (deduplication.get(reporter).add(reported)) {
                hashMap.put(reported, hashMap.getOrDefault(reported, 0) + 1);
            }
        }

        List<String> disabled = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() >= k) {
                disabled.add(entry.getKey());
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            Set<String> reported_list = deduplication.get(id_list[i]);
            int mailCount = 0;

            for (String reported : reported_list) {
                if (disabled.contains(reported)) {
                    mailCount++;
                }
            }

            answer[i] = mailCount;
        }

        return answer;
    }
}
