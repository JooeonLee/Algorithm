import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        long m = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long maxCnt = Long.MIN_VALUE;
        long minCnt = Long.MAX_VALUE;
        // Please write your code here.
        for(long i=a; i<=b; i++) {
            long currCnt = bs(m, i);
            maxCnt = Math.max(maxCnt, currCnt);
            minCnt = Math.min(minCnt, currCnt);
        }

        sb.append(minCnt).append(' ').append(maxCnt);
        System.out.println(sb);
    }

    public static long bs(long m, long target) {
        long cnt = 0;
        long left = 1;
        long right = m;

        while(left <= right) {
            long mid = left + (right-left)/2;
            cnt++;

            if(mid == target)
                return cnt;
            else if(mid > target)
                right = mid-1;
            else
                left = mid+1;
        }
        return cnt;
    }
}