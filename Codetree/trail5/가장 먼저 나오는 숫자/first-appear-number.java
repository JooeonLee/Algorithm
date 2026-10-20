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
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
            int lbIdx = lb(queries[i], arr);
            if(lbIdx != -1 && arr[lbIdx] == queries[i])
                sb.append(lbIdx+1);
            else
                sb.append(-1);
            sb.append('\n');
        }
        // Please write your code here.
        System.out.print(sb);
    }

    public static int lb(int target, int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int answer = -1;

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
}