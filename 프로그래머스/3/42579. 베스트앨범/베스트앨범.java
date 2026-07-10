import java.util.*;

class Solution {
    // 곡의 정보를 담을 클래스
    static class Song {
        int id;
        int play;

        public Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlaySum = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlaySum.put(genre, genrePlaySum.getOrDefault(genre, 0) + play);
            
            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new ArrayList<>());
            }
            genreSongs.get(genre).add(new Song(i, play));
        }

        List<String> sortedGenres = new ArrayList<>(genrePlaySum.keySet());
        sortedGenres.sort((a, b) -> genrePlaySum.get(b) - genrePlaySum.get(a));

        List<Integer> resultList = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);

            songs.sort((s1, s2) -> {
                if (s1.play == s2.play) {
                    return s1.id - s2.id;
                }
                return s2.play - s1.play;
            });

            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                resultList.add(songs.get(i).id);
            }
        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }
}