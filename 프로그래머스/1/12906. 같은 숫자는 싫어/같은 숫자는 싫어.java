import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = {};
        
        stack.push(arr[0]);
        for(int i=0; i<arr.length; i++) {
            if(stack.peek() == arr[i])
                continue;
            else
                stack.push(arr[i]);
        }

        return stack.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}