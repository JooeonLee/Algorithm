import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
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
                stack.push(pq.poll());
            } else {
                route.add(stack.pop());
            }
        }

        Collections.reverse(route);
        return route.toArray(new String[0]);
    }
}