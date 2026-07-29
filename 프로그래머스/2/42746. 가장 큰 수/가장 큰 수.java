import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<Integer> numberList = new ArrayList<>();
        for(int num : numbers)
            numberList.add(num);
        
        numberList.sort((a, b) -> {
            String ab = String.valueOf(a) + String.valueOf(b);
            String ba = String.valueOf(b) + String.valueOf(a);
            
            int numAb = Integer.parseInt(ab);
            int numBa = Integer.parseInt(ba);
            
            return Integer.compare(numBa, numAb);
        });
        
        if(numberList.get(0) == 0)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        
        for(Integer number : numberList)
            sb.append(number);
        
        return sb.toString();
    }
}