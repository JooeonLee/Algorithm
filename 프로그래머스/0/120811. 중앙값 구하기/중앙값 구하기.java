import java.util.*;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        
        return array[(1 + array.length)/2 -1];
    }
}