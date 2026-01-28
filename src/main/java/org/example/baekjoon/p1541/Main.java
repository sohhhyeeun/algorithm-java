package org.example.baekjoon.p1541;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();

        int sum = 0;
        String[] splitByMinus = expression.split("-");

        for (int i = 0; i < splitByMinus.length; i++) {
            int addition = 0;
            String[] splitByPlus = splitByMinus[i].split("\\+");

            for (int j = 0; j < splitByPlus.length; j++) {
                addition += Integer.parseInt(splitByPlus[j]);
            }

            if (i == 0) {
                sum += addition;
            } else {
                sum -= addition;
            }
        }

        System.out.println(sum);
    }
}
