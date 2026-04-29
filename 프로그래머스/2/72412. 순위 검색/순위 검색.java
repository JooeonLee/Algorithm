import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        for(String s : info) {
            String[] parts = s.split(" ");
            buildKeys(parts, 0, "", Integer.parseInt(parts[4]));
        }
        
        for(List<Integer> list : map.values())
            Collections.sort(list);
        
        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++) {
            String[] q = query[i].replace("and", "").split("\\s+");
            String key = q[0] + q[1] + q[2] + q[3];
            int score = Integer.parseInt(q[4]);
            
            if(!map.containsKey(key)) {
                answer[i] = 0;
                continue;
            }
            
            List<Integer> list = map.get(key);
            answer[i] = list.size() - lowerBound(list, score);
        }
        
        return answer;
    }
    
    void buildKeys(String[] parts, int depth, String key, int score) {
        if(depth == 4) {
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            return;
        }
        buildKeys(parts, depth+1, key+parts[depth], score);
        buildKeys(parts, depth+1, key+"-", score);
    }
    
    int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            if(list.get(mid) >= target)
                right = mid;
            else
                left = mid + 1;
        }
        
        return left;
    }
}