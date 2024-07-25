import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = Arrays.copyOf(strings, strings.length);
        
        Arrays.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.charAt(n) != s2.charAt(n)) {
                    return Character.compare(s1.charAt(n), s2.charAt(n));
                }
                
                return s1.compareTo(s2);
            }
        });
        
        return answer;
    }
}