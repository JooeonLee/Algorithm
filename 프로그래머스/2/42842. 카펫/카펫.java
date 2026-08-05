import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        ArrayList<int[]> yMeasure = measure(yellow);
        
        for(int[] e : yMeasure) {
            if((e[0]+2) * (e[1]+2) == total) {
                answer[0] = e[1] + 2;
                answer[1] = e[0] + 2;
            }
        }
        
        return answer;
    }
    
    private ArrayList<int[]> measure(int num) {
        ArrayList<int[]> result = new ArrayList<>();
        int mid = (int)Math.sqrt(num);
        
        for(int i=1; i<=mid; i++) {
            if(num % i == 0)
                result.add(new int[]{i, num/i});
        }
        
        return result;
    } 
}