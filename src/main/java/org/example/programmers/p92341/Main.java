package org.example.programmers.p92341;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        Main T = new Main();

        System.out.println(Arrays.toString(T.solution(fees, records)));
    }

    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> parkingRecord = new HashMap<>();
        HashMap<String, Integer> cumulativeParkingTime = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            String time = record[0];
            String carNum = record[1];
            String history = record[2];

            if (history.equals("IN")) {
                parkingRecord.put(carNum, time);
            } else {
                if (parkingRecord.containsKey(carNum)) {
                    int outMinute = timeToMinutes(time);
                    int inMinute = timeToMinutes(parkingRecord.get(carNum));
                    int totalMinute = outMinute - inMinute;

                    cumulativeParkingTime.put(carNum, cumulativeParkingTime.getOrDefault(carNum, 0) + totalMinute);
                    parkingRecord.remove(carNum);
                }
            }
        }

        int endOfDayMinute = timeToMinutes("23:59");
        for (String carNum : parkingRecord.keySet()) {
            int inMinute = timeToMinutes(parkingRecord.get(carNum));
            int totalMinute = endOfDayMinute - inMinute;

            cumulativeParkingTime.put(carNum, cumulativeParkingTime.getOrDefault(carNum, 0) + totalMinute);
        }

        List<String> carsNum = new ArrayList<>(cumulativeParkingTime.keySet());
        Collections.sort(carsNum);

        int[] answer = new int[carsNum.size()];

        for (int i = 0; i < answer.length; i++) {
            int parkingTime = cumulativeParkingTime.get(carsNum.get(i));

            if (parkingTime <= fees[0]) {
                answer[i] = fees[1];
            } else {
                int extraFee = (int) Math.ceil((parkingTime - fees[0]) / (double) fees[2]) * fees[3];

                answer[i] = fees[1] + extraFee;
            }
        }

        return answer;
    }

    private int timeToMinutes(String time) {
        String[] splitTime = time.split(":");

        return (Integer.parseInt(splitTime[0]) * 60) + Integer.parseInt(splitTime[1]);
    }
}
