import java.util.*;

/**
pq에 다 넣고 2개씩 뽑아서 다시 넣고 pq의 탑이 K 이상일 때 찾으면 될거같은디
*/
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville)
            pq.offer(s);
        
        while(pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            
            if(first >= K) {
                pq.offer(first);
                pq.offer(second);
                break;
            }
            else {
                pq.offer(first+second*2);
                answer++;
            }
        }
        
        if(pq.peek() < K)
            return -1;
        else
            return answer;
    }
}