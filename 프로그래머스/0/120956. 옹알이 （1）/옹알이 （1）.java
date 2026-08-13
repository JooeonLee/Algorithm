import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        Set<String> words = new HashSet<>();
        
        for(String curr : babbling) {
            String str1 = curr.replace("aya", "!");
            String str2 = str1.replace("ye", "!");
            String str3 = str2.replace("woo", "!");
            String str4 = str3.replace("ma", "!");
            
            if(str4.equals("!") || str4.equals("!!") || str4.equals("!!!") || str4.equals("!!!!"))
                answer++;
        }
        return answer;
    }
}