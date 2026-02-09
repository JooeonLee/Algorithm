class Solution {
    public int solution(String name) {
        int n = name.length();

        // 1) 상하 이동(문자 변경) 비용
        int vertical = 0;
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            int up = c - 'A';
            int down = 'Z' - c + 1;
            vertical += Math.min(up, down);
        }

        // 2) 좌우 이동(커서 이동) 최소 비용
        // 기본값: 그냥 오른쪽으로 끝까지 (n-1)
        int horizontal = n - 1;

        for (int i = 0; i < n; i++) {
            int next = i + 1;

            // i 다음부터 연속된 'A' 구간의 끝(next) 찾기
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // 케이스1: 오른쪽으로 i까지 갔다가 왼쪽으로 되돌아가서(0으로) 끝쪽으로 가기
            // i*2 + (n - next)
            int move1 = i * 2 + (n - next);

            // 케이스2: 반대로 먼저 왼쪽(끝쪽)으로 갔다가 돌아오기
            // (n - next)*2 + i
            int move2 = (n - next) * 2 + i;

            horizontal = Math.min(horizontal, Math.min(move1, move2));
        }

        return vertical + horizontal;
    }
}
