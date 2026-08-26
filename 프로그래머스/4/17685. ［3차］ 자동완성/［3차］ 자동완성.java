import java.util.*;

class Solution {
    class Trie {
        static class Node {
            Map<Character, Node> child = new HashMap<>();
            int cnt = 0;
        }
        
        private final Node root = new Node();
        
        // 삽입
        public void insert(String word) {
            Node curr = root;
            for(char c : word.toCharArray()) {
                curr = curr.child.computeIfAbsent(c, k -> new Node());
                curr.cnt++;
            }
        }

        private int minAutoCompleteCnt(String word) {
            Node curr = root;
            for(int i=0; i<word.length(); i++) {
                curr = curr.child.get(word.charAt(i));
                if(curr.cnt == 1)
                    return i+1;
            }
            return word.length();
        }
    }
    public int solution(String[] words) {
        Trie trie = new Trie();
        for(String word : words)
            trie.insert(word);
        
        int answer = 0;
        for(String word : words)
            answer += trie.minAutoCompleteCnt(word);
        
        return answer;
    }
}