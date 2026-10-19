/**
works 20000 이하 n^2 안됨
뭔가 평균적으로 크기들을 맞추면 될 것 같은데 왜 그런지 논지적으로 설명을 못하겠네
일단 구현 해보기
*/

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        for(int work : works)
            pq.offer(work);
        
        int cnt = 0;
        while(cnt < n && !pq.isEmpty()) {
            int curr = pq.poll();
            curr--;
            cnt++;
            
            if(curr == 0)
                continue;
            
            pq.offer(curr);
        }
        
        while(!pq.isEmpty()) {
            int curr = pq.poll();
            answer += (long) curr * curr;
        }
        
        return answer;
    }
}