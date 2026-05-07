class Solution {
    public String solution(int age) {
        String answer = "";
        
        while(age > 0) {
            int curr = age % 10;
            answer = (char) (curr + 'a') + answer;
            age = age / 10;
        }
        
        return answer;
    }
}