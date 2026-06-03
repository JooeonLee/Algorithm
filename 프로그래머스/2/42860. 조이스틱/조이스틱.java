class Solution {
    public int solution(String name) {
        int n = name.length();

        int vertical = 0;
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            int up = c - 'A';
            int down = 'Z' - c + 1;
            vertical += Math.min(up, down);
        }

        int horizontal = n - 1;

        for (int i = 0; i < n; i++) {
            int next = i + 1;

            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            int move1 = i * 2 + (n - next);

            int move2 = (n - next) * 2 + i;

            horizontal = Math.min(horizontal, Math.min(move1, move2));
        }

        return vertical + horizontal;
    }
}
