import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // target이 words에 없으면 변환 불가
        boolean exists = false;
        for (String w : words) {
            if (w.equals(target)) {
                exists = true;
                break;
            }
        }
        if (!exists) return 0;

        // BFS: (현재 단어, 변환 단계 수)
        Queue<String> q = new ArrayDeque<>();
        Queue<Integer> distQ = new ArrayDeque<>();

        boolean[] visited = new boolean[words.length];

        q.offer(begin);
        distQ.offer(0);

        while (!q.isEmpty()) {
            String cur = q.poll();
            int dist = distQ.poll();

            if (cur.equals(target)) return dist;

            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (diffOne(cur, words[i])) {
                    visited[i] = true;
                    q.offer(words[i]);
                    distQ.offer(dist + 1);
                }
            }
        }

        return 0;
    }

    private boolean diffOne(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}