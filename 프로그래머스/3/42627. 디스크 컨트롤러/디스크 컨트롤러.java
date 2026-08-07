import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        ArrayList<int[]> jobList = new ArrayList<>();
        
        for(int i=0; i<jobs.length; i++) {
            int[] job = new int[] {jobs[i][0], jobs[i][1], i};
            jobList.add(job);
        }
        
        jobList.sort((a, b) -> {
            if(a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[2], b[2]);
        });
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            else if(a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            else
                return Integer.compare(a[2], b[2]);
            
        });
        int total = 0;
        int currTime = 0;
        int idx = 0;
        while(!pq.isEmpty() || idx < jobList.size()) {
            // 현재 시간보다 요청 시간이 이전인 모든 작업 큐에 삽입
            while(idx < jobList.size() && jobList.get(idx)[0] <= currTime) {
                int[] nextJob = jobList.get(idx);
                pq.offer(nextJob);
                idx++;
            }
            
            // 작업 큐가 비었다면 점프
            if(pq.isEmpty()) {
                currTime = jobList.get(idx)[0];
                continue;
            }
            
            int[] currJob = pq.poll();
            // 큐에서 뽑았으면 바로 해당 작업의 완료시간으로
            currTime += currJob[1];
            
            // 큐에서 뽑았으면 작업 수행시간계산
            total += currTime - currJob[0];
        }
        
        return total / jobList.size();
        
    }
}

/*
* 큐에 작업 넣어서 진행 But 우선 순위 큐 사용해서 빼고 넣으면서 진행
* 모든 job을 한번에 넣어서 진행하지 않는다. 
* 일종의 시뮬레이션 처럼 시간을 기준으로 현재 시간을 확인하고 job을 넣거나 빼면서 작업 진행
* 입력으로 들어오는 jobs 배열이 시간순으로 정렬되어있다는 보장이 없으므로 정렬해서 시뮬레이션 진행
*/
