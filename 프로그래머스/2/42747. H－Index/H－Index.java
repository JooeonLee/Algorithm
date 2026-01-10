import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int citation = citations[n - 1 - i]; // 뒤에서부터
            if (citation >= i + 1) {
                h = i + 1;
            } else {
                break;
            }
        }

        return h;
    }
}