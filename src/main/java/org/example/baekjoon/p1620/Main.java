package org.example.baekjoon.p1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();
        String[] names = new String[N + 1];

        for (int n = 1; n <= N; n++) {
            String name = br.readLine();

            nameMap.put(name, n);
            names[n] = name;
        }

        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < M; m++) {
            String question = br.readLine();

            if (Character.isDigit(question.charAt(0))) {
                int number = Integer.parseInt(question);
                sb.append(names[number]).append("\n");
            } else {
                sb.append(nameMap.get(question)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
