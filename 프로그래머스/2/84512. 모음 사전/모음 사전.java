class Solution {
    private final String[] vowels = {"A", "E", "I", "O", "U"};
    private int count = 0;
    private int answer = 0;

    public int solution(String word) {
        dfs("", word);
        return answer;
    }

    private void dfs(String current, String target) {
        if (answer != 0) {
            return;
        }

        if (current.length() == 5) {
            return;
        }

        for (String vowel : vowels) {
            String next = current + vowel;

            count++;

            if (next.equals(target)) {
                answer = count;
                return;
            }

            dfs(next, target);
        }
    }
}