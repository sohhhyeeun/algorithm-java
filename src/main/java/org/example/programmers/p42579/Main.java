package org.example.programmers.p42579;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] result = T.solution(genres, plays);

        System.out.println(Arrays.toString(result));
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();

        HashMap<String, Integer> sortByGenre = new HashMap<>();
        HashMap<String, ArrayList<int[]>> sortByPlay = new HashMap<>(); // int[고유 번호, 재생 횟수]

        for (int i = 0; i < genres.length; i++) {
            sortByGenre.put(genres[i], sortByGenre.getOrDefault(genres[i], 0) + plays[i]);

            if (!sortByPlay.containsKey(genres[i])) {
                sortByPlay.put(genres[i], new ArrayList<>());
            }

            sortByPlay.get(genres[i]).add(new int[]{i, plays[i]});
        }

        ArrayList<String> genreKeys = new ArrayList<>(sortByGenre.keySet());

        Collections.sort(genreKeys, (o1, o2) -> sortByGenre.get(o2) - sortByGenre.get(o1));

        for (String genreKey : genreKeys) {
            ArrayList<int[]> songs = sortByPlay.get(genreKey);

            Collections.sort(songs, (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o2[1] - o1[1];
            });

            for (int i = 0; i < songs.size() && i < 2; i++) {
                answerList.add(songs.get(i)[0]);
            }
        }

        answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
