import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        Arrays.sort(points);
        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            int gteIdx = gteMin(a, points);
            int lteIdx = lteMax(b, points);
            sb.append(Math.max(0, lteIdx-gteIdx+1)).append('\n');
        }
        
        // Please write your code here.
        System.out.print(sb);
    }

    public static int gteMin(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        int answer = arr.length;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(arr[mid] >= target) {
                right = mid-1;
                answer = mid;
            }
            else
                left = mid+1;
        }
        return answer;
    }

    public static int lteMax(int target, int[] arr) {
        int left = 0;
        int right = arr.length-1;

        int answer = -1;

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(arr[mid] <= target) {
                left = mid+1;
                answer = mid;
            }
            else
                right = mid-1;
        }
        return answer;
    }
}