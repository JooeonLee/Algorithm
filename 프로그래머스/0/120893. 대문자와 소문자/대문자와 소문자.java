import java.util.*;

class Solution {
    public String solution(String my_string) {
        StringBuffer sb = new StringBuffer();
        
        for(char c : my_string.toCharArray()) {
            if(Character.isUpperCase(c))
                sb.append(Character.toLowerCase(c));
            else
                sb.append(Character.toUpperCase(c));
        }
        
        return sb.toString();
    }
}