import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] lowerCase =  my_string.toLowerCase().toCharArray();
        Arrays.sort(lowerCase);
        return new String(lowerCase);
    }
}