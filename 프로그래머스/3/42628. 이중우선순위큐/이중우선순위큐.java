import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqD = new PriorityQueue<>(Collections.reverseOrder());
        
        int cnt = 0;
        int numlength = 0;
        for(String operation : operations) {
            String[] arr = operation.split(" ");
            String operationType = arr[0];
            String numString = arr[1];
            
            if(operationType.equals("I")) {
                int num = Integer.parseInt(numString);
                pqA.offer(num);
                pqD.offer(num);
                numlength++;
            }
            
            if(operationType.equals("D")) {
                int num = Integer.parseInt(numString);
                
                if(num == 1 && cnt < operations.length) {
                    if(!pqD.isEmpty()) {
                        Integer min = pqD.poll();
                        if(!pqA.isEmpty())
                            pqA.remove(min);
                        cnt++;
                    }
                }
                else if(num == -1 && cnt < operations.length) {
                    if(!pqA.isEmpty()) {
                        Integer max = pqA.poll();
                        if(!pqD.isEmpty())
                            pqD.remove(max);
                        cnt++;
                    }
                }
            }
        }
        
        int[] answer = new int[2];
        if(cnt < numlength) {
            answer[0] = pqD.peek();
            answer[1] = pqA.peek();
        }
        return answer;
    }
}