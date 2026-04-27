class Solution {
    public int solution(int n) {
        int answer = 0;
        int curr = n;
        
        while(curr != 0) {
            answer += curr % 10;
            curr = curr / 10;
        }
        return answer;
    }
}