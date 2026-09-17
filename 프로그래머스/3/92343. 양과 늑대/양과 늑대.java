import java.util.*;

class Solution {
    static int answer;
    static ArrayList<Node> tree;

    public int solution(int[] info, int[][] edges) {
        answer = 0;
        tree = new ArrayList<>();

        for(int i = 0; i < info.length; i++) {
            tree.add(new Node(info[i]));
        }

        for(int[] edge : edges) {
            Node parent = tree.get(edge[0]);
            Node child = tree.get(edge[1]);

            parent.setChild(child);
        }

        Node root = tree.get(0);

        ArrayList<Node> candidates = new ArrayList<>();

        if(root.leftChild != null)
            candidates.add(root.leftChild);

        if(root.rightChild != null)
            candidates.add(root.rightChild);

        dfs(1, 0, candidates);

        return answer;
    }

    static void dfs(int sCnt, int wCnt, ArrayList<Node> candidates) {
        answer = Math.max(answer, sCnt);

        for(int i = 0; i < candidates.size(); i++) {
            Node curr = candidates.get(i);

            int nextScnt = sCnt;
            int nextWcnt = wCnt;

            if(curr.type == 0)
                nextScnt++;
            else
                nextWcnt++;

            // 늑대 수가 양 수 이상이면 더 이상 탐색 불가
            if(nextWcnt >= nextScnt)
                continue;

            // 현재 선택한 노드를 후보에서 제거
            ArrayList<Node> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(i);

            // 현재 노드의 자식을 새로운 후보로 추가
            if(curr.leftChild != null)
                nextCandidates.add(curr.leftChild);

            if(curr.rightChild != null)
                nextCandidates.add(curr.rightChild);

            dfs(nextScnt, nextWcnt, nextCandidates);
        }
    }

    static class Node {
        int type;

        Node leftChild;
        Node rightChild;

        public Node(int type) {
            this.type = type;
        }

        public void setChild(Node child) {
            if(leftChild == null)
                leftChild = child;
            else
                rightChild = child;
        }
    }
}