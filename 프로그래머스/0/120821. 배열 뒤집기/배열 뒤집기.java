import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        for (int num : num_list) {
            arr.add(num);
        }
        Collections.reverse(arr);
        return arr.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}