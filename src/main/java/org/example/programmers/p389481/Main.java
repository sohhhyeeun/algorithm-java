package org.example.programmers.p389481;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long n = 7388;
        String[] bans = {"gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"};

        Main T = new Main();

        System.out.println(T.solution(n, bans));
    }

    public String solution(long n, String[] bans) {
        String answer = "";

        long[] convertedBans = new long[bans.length];

        for (int i = 0; i < bans.length; i++) {
            long num = 0;

            for (int j = 0; j < bans[i].length(); j++) {
                long digit = bans[i].charAt(j) - 'a' + 1;
                num = num * 26 + digit;
            }

            convertedBans[i] = num;
        }

        Arrays.sort(convertedBans);

        for (int i = 0; i < convertedBans.length; i++) {
            if (n >= convertedBans[i]) {
                n += 1;
            } else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            long remainder = (n - 1) % 26;
            sb.append((char) (remainder + 'a'));
            n = (n - 1) / 26;
        }

        answer = sb.reverse().toString();

        return answer;
    }
}
