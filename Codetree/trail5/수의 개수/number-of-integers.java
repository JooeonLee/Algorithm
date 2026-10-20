import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            // Please write your code here.
            int lbIdx = lb(x, arr);
            int ubIdx = ub(x, arr);
            sb.append(ubIdx-lbIdx).append('\n');
        }
        System.out.println(sb);
    }

    public static int lb(int target, int[] arr) {
        int left = 0;
        int right = arr.length-1;

        int answer = arr.length;
        while(left<=right) {
            int mid = left + (right-left)/2;

            if(arr[mid]>=target) {
                right = mid-1;
                answer = mid;
            }
            else
                left = mid+1;
        }
        return answer;
    }
    
    public static int ub(int target, int[] arr) {
        int left = 0;
        int right = arr.length-1;

        int answer = arr.length;
        while(left<=right) {
            int mid = left + (right-left)/2;

            if(arr[mid]>target) {
                right = mid-1;
                answer = mid;
            }
            else
                left = mid+1;
        }
        return answer;
    } 
}