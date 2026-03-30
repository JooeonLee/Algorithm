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
        Map<String, Integer> genrePlaySum = new HashMap<>(); // 장르별 총 재생 횟수
        Map<String, List<Song>> genreSongs = new HashMap<>(); // 장르별 곡 목록

        // 1. 데이터 채우기
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlaySum.put(genre, genrePlaySum.getOrDefault(genre, 0) + play);
            
            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new ArrayList<>());
            }
            genreSongs.get(genre).add(new Song(i, play));
        }

        // 2. 총 재생 횟수 순으로 장르 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlaySum.keySet());
        sortedGenres.sort((a, b) -> genrePlaySum.get(b) - genrePlaySum.get(a));

        List<Integer> resultList = new ArrayList<>();

        // 3. 각 장르 내에서 조건에 따라 곡 선택
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);

            // 장르 내 정렬 기준: 
            // 1. 재생 횟수 내림차순 
            // 2. 재생 횟수 같으면 고유 번호(id) 오름차순
            songs.sort((s1, s2) -> {
                if (s1.play == s2.play) {
                    return s1.id - s2.id;
                }
                return s2.play - s1.play;
            });

            // 최대 2곡까지만 결과에 추가
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                resultList.add(songs.get(i).id);
            }
        }

        // 4. 리스트를 배열로 변환하여 반환
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}