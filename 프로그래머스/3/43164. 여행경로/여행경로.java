import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 출발지 -> (도착지들을 사전순으로 꺼내기 위한 PQ)
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (String[] t : tickets) {
            graph.computeIfAbsent(t[0], k -> new PriorityQueue<>()).offer(t[1]);
        }

        Deque<String> stack = new ArrayDeque<>();
        List<String> route = new ArrayList<>();
        stack.push("ICN");

        // Iterative Hierholzer
        while (!stack.isEmpty()) {
            String cur = stack.peek();
            PriorityQueue<String> pq = graph.get(cur);

            if (pq != null && !pq.isEmpty()) {
                // 사전순으로 가장 앞선 목적지부터 사용
                stack.push(pq.poll());
            } else {
                // 더 이상 나갈 간선이 없으면 경로에 확정 (역순으로 쌓임)
                route.add(stack.pop());
            }
        }

        Collections.reverse(route);
        return route.toArray(new String[0]);
    }
}