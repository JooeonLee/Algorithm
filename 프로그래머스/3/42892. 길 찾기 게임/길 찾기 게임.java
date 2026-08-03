import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] answers = new int[2][];
        
        Node root = makeBT(nodeinfo);
        preOrder(root, answer);
        answers[0] = answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        answer.clear();
        postOrder(root, answer);
        answers[1] = answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        return answers;
    }
    
    private static class Node {
        int x, y, num;
        Node left, right;
        
        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    private static Node makeBT(int[][] nodeinfo) {
        Node[] nodes = new Node[nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++) {
            nodes[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        Arrays.sort(nodes, (n1, n2) -> {
            if(n1.y == n2.y)
                return Integer.compare(n1.x, n2.x);
            return Integer.compare(n2.y, n1.y);
        });
        
        Node root = nodes[0];
        
        for(int i=1; i<nodes.length; i++) {
            Node parent = root;
            while(true) {
                if(nodes[i].x < parent.x) {
                    if(parent.left == null) {
                        parent.left = nodes[i];
                        break;
                    }
                    else
                        parent = parent.left;
                }
                
                else {
                    if(parent.right == null) {
                        parent.right = nodes[i];
                        break;
                    }
                    else
                        parent = parent.right;
                }
            }
        }
        return nodes[0];
    }
    
    private static void preOrder(Node curr, ArrayList<Integer> answer) {
        if(curr == null)
            return;
        
        answer.add(curr.num);
        preOrder(curr.left, answer);
        preOrder(curr.right, answer);
    }
    
    private static void postOrder(Node curr, ArrayList<Integer> answer) {
        if(curr == null)
            return;
        
        postOrder(curr.left, answer);
        postOrder(curr.right, answer);
        answer.add(curr.num);
    }
}