import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> typeCountMap = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            typeCountMap.put(type, typeCountMap.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        for (int count : typeCountMap.values()) {
            answer *= (count + 1);
        }
        
        return answer - 1;
    }
}