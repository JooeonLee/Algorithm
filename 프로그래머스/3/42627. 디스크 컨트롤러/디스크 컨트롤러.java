import java.util.*;

class Solution {

    static class Job {
        int id;       // 작업 번호
        int start;    // 요청 시각
        int length;   // 소요 시간

        Job(int id, int start, int length) {
            this.id = id;
            this.start = start;
            this.length = length;
        }
    }

    public int solution(int[][] jobs) {
        int n = jobs.length;

        Job[] arr = new Job[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }

        // 아직 도착하지 않은 작업들을 요청 시각 순으로 정렬
        Arrays.sort(arr, (a, b) -> {
            if (a.start != b.start) return a.start - b.start;
            return a.id - b.id;
        });

        // 대기 큐: 소요시간 -> 요청시각 -> 작업번호 순으로 우선순위
        PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> {
            if (a.length != b.length) return a.length - b.length;
            if (a.start != b.start) return a.start - b.start;
            return a.id - b.id;
        });

        int time = 0;          // 현재 시각
        int idx = 0;           // 아직 pq에 넣지 않은 arr의 인덱스
        int completed = 0;     // 완료한 작업 수
        long totalTurnaround = 0;

        while (completed < n) {
            // 현재 시각까지 요청된 작업을 모두 대기 큐에 넣기
            while (idx < n && arr[idx].start <= time) {
                pq.offer(arr[idx]);
                idx++;
            }

            if (!pq.isEmpty()) {
                Job cur = pq.poll();

                time += cur.length; // 현재 작업 수행
                totalTurnaround += (time - cur.start);
                completed++;
            } else {
                // 대기 큐가 비어 있으면 다음 작업 요청 시각으로 점프
                time = arr[idx].start;
            }
        }

        return (int) (totalTurnaround / n);
    }
}