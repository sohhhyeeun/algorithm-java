package org.example.programmers.p42579;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Music {
    int id;
    int play;

    public Music(int id, int play) {
        this.id = id;
        this.play = play;
    }
}

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
        HashMap<String, ArrayList<Music>> sortByPlay = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            sortByGenre.put(genres[i], sortByGenre.getOrDefault(genres[i], 0) + plays[i]);

            if (!sortByPlay.containsKey(genres[i])) {
                sortByPlay.put(genres[i], new ArrayList<>());
            }

            sortByPlay.get(genres[i]).add(new Music(i, plays[i]));
        }

        ArrayList<String> genreKeys = new ArrayList<>(sortByGenre.keySet());

        Collections.sort(genreKeys, (o1, o2) -> sortByGenre.get(o2) - sortByGenre.get(o1));

        for (String genreKey : genreKeys) {
            ArrayList<Music> songs = sortByPlay.get(genreKey);

            Collections.sort(songs, (o1, o2) -> {
                if (o1.play == o2.play) {
                    return o1.id - o2.id;
                }

                return o2.play - o1.play;
            });

            for (int i = 0; i < songs.size() && i < 2; i++) {
                answerList.add(songs.get(i).id);
            }
        }

        answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
