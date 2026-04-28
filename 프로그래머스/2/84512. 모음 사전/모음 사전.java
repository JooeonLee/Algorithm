import java.util.*;
class Solution {
    String[] vowels = {"A", "E", "I", "O", "U"};
    List<String> dic = new ArrayList<>();
    
    public int solution(String word) {
        generate("");
        return dic.indexOf(word)+1;
    }
    
    void generate(String current) {
        if(current.length() > 5)
            return;
        if(!current.isEmpty())
            dic.add(current);
        
        for(String v : vowels) {
            generate(current + v);
        }
    }
}