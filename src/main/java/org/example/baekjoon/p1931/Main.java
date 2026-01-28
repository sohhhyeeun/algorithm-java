package org.example.baekjoon.p1931;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] meetings = new int[N][2];
        for (int i = 0; i < N; i++) {
            meetings[i][0] = sc.nextInt(); //시작 시간
            meetings[i][1] = sc.nextInt(); //종료 시간
        }

        //커스텀 정렬(Custom Sort)
        //o1: 비교할 첫 번째 회의
        //o2: 비교할 두 번째 회의
        //o1[0]: 시작 시간, o1[1]: 종료 시간
        Arrays.sort(meetings, (o1, o2) -> {
            //종료 시간이 같을 경우, 시작 시간이 빠른 순으로 정렬
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            
            //종료 시간이 빠른 순으로 정렬(오름차순)
            return o1[1] - o2[1];
        });

        int count = 1;
        int meetingEndTime = meetings[0][1];
        for (int i = 1; i < N; i++) {
            if (meetings[i][0] >= meetingEndTime) {
                meetingEndTime = meetings[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
