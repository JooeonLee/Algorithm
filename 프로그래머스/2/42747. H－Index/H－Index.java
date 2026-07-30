import java.util.*;

class Solution {
    public int solution(int[] citations) {
        ArrayList<Integer> citationList = new ArrayList<>();
        for(int citation : citations)
            citationList.add(citation);
        citationList.sort(Comparator.reverseOrder());
        
        int hIdx = 0;
        for(int i=0; i<citationList.size(); i++) {
            if(citationList.get(i) < i+1)
                break;
            hIdx = i;
        }
        
        if(hIdx == 0 && citationList.get(hIdx) == 0)
            return 0;
        return hIdx+1;
    }
}