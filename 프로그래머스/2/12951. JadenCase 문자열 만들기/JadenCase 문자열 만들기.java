import java.lang.Character;
import java.lang.StringBuilder;

class Solution {
    public String solution(String s) {
        String[] words = s.split(" ", -1);
        StringBuilder answer = new StringBuilder();
        
        for(String word : words) {
            if(word.length() > 0) {
                char firstChar = word.charAt(0);
                if(Character.isAlphabetic(firstChar)) {
                    answer.append(Character.toUpperCase(firstChar))
                        .append(word.substring(1).toLowerCase());
                } else {
                    answer.append(word.toLowerCase());
                }
            }
            
            answer.append(" ");
        }
        
        if(answer.length() > 0 && answer.charAt(answer.length()-1) == ' ')
            answer.deleteCharAt(answer.length() - 1);
        
        return answer.toString();
    }
}