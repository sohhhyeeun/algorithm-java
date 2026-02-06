package org.example.baekjoon.p9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();

                clothes.put(category, clothes.getOrDefault(category, 0) + 1);
            }

            int result = 1;
            for (int number : clothes.values()) {
                result *= (number + 1); // 해당 종류를 안 입는 경우 포함
            }

            sb.append(result - 1).append("\n"); // 알몸인 상태 제외
        }

        System.out.println(sb);
    }
}
