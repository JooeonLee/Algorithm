import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        ArrayList<TrafficLight> lights = new ArrayList<>();
        for(int[] signal : signals) {
            lights.add(new TrafficLight(signal[0], signal[1], signal[2]));
        }
        
        int cycle = 1;
        int answer = -1;
        for(int i=0; i<lights.size(); i++) {
            TrafficLight curr = lights.get(i);
            cycle = lcm(cycle, curr.cycle());
        }
        
        for(int i=1; i<=cycle; i++) {
            boolean isAllYellow = true;
            
            for(TrafficLight light : lights) {
                if(!light.isYellow(i)) {
                    isAllYellow = false;
                    break;
                }
            }
            
            if(isAllYellow) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    static class TrafficLight {
        int green;
        int yellow;
        int red;
        
        TrafficLight(int green, int yellow, int red) {
            this.green = green;
            this.yellow = yellow;
            this.red = red;
        }
        
        int cycle() {
            return green + yellow + red;
        }
        
        boolean isYellow(int time) {
            // 0-based
            int t = (time-1) % cycle();
            
            return this.green <= t && t < this.green + this.yellow;
        }
    }
    
    public int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
    
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}