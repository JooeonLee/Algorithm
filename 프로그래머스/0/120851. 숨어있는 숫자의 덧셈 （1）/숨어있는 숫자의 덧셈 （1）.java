import java.util.*;

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        ArrayList<Character> arr = new ArrayList<>();
        for(char c : my_string.toCharArray())
            arr.add(c);
        
        return arr.stream()
            .filter(c -> Character.isDigit(c))
            .mapToInt(c -> c - '0')
            .sum();
    }
}