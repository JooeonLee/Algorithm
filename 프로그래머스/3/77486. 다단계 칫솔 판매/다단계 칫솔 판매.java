import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral,
                          String[] seller, int[] amount) {
        
        int n = enroll.length;
        
        // 이름 -> 번호
        HashMap<String, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            indexMap.put(enroll[i], i);
        }
        
        // parent[i] = i번 판매원의 추천인
        // 추천인이 center라면 -1
        int[] parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (referral[i].equals("-")) {
                parent[i] = -1;
            } else {
                parent[i] = indexMap.get(referral[i]);
            }
        }
        
        int[] answer = new int[n];
        
        // 각각의 판매 기록 처리
        for (int i = 0; i < seller.length; i++) {
            int curr = indexMap.get(seller[i]);
            int money = amount[i] * 100;
            
            // 판매자부터 추천인을 따라 위로 올라간다.
            while (curr != -1 && money > 0) {
                int give = money / 10;
                int keep = money - give;
                
                answer[curr] += keep;
                
                // 더 이상 추천인에게 전달할 돈이 없다.
                if (give == 0) {
                    break;
                }
                
                money = give;
                curr = parent[curr];
            }
        }
        
        return answer;
    }
}