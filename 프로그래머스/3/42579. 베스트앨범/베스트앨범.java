import java.util.*;

class Solution {

    static class Song {
        int id;
        int plays;

        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        // 1. 장르별 총 재생 수
        Map<String, Integer> genreTotalPlays = new HashMap<>();

        // 2. 장르별 노래 목록
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genreTotalPlays.put(
                genres[i],
                genreTotalPlays.getOrDefault(genres[i], 0) + plays[i]
            );

            genreSongs
                .computeIfAbsent(genres[i], g -> new ArrayList<>())
                .add(new Song(i, plays[i]));
        }

        // 3. 장르를 총 재생 수 기준으로 정렬
        List<String> genreOrder = new ArrayList<>(genreTotalPlays.keySet());
        genreOrder.sort((a, b) ->
            genreTotalPlays.get(b) - genreTotalPlays.get(a)
        );

        List<Integer> result = new ArrayList<>();

        // 4. 각 장르에서 상위 2곡 선택
        for (String genre : genreOrder) {
            List<Song> songs = genreSongs.get(genre);

            songs.sort((s1, s2) -> {
                if (s1.plays != s2.plays) {
                    return s2.plays - s1.plays; // 재생 수 내림차순
                }
                return s1.id - s2.id; // 고유 번호 오름차순
            });

            result.add(songs.get(0).id);
            if (songs.size() > 1) {
                result.add(songs.get(1).id);
            }
        }

        // 5. List → int[]
        return result.stream().mapToInt(i -> i).toArray();
    }
}
