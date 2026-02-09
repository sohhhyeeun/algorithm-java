package org.example.programmers.p42888;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] record = {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };

        String[] result = solution(record);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] record) {
        String[] answer = {};

        HashMap<String, String> map = new HashMap<>();

        for (String r : record) {
            String[] parts = r.split(" ");
            String uid = parts[1];

            if (parts[0].equals("Enter") || parts[0].equals("Change")) {
                String nickname = parts[2];

                map.put(uid, nickname);
            }
        }

        ArrayList<String> result = new ArrayList<>();

        for (String r : record) {
            String[] parts = r.split(" ");
            String uid = parts[1];

            if (parts[0].equals("Enter")) {
                result.add(map.get(uid) + "님이 들어왔습니다.");
            } else if (parts[0].equals("Leave")) {
                result.add(map.get(uid) + "님이 나갔습니다.");
            }
        }

        answer = result.toArray(new String[0]);

        return answer;
    }
}
