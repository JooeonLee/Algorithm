import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0)+1);
        }
        
        for(int i=0; i<completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0)-1);
        }
        
        for(String name: map.keySet()) {
            if(map.get(name) > 0)
                answer = name;
        }
        
        return answer;
    }
}