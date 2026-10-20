import java.util.Scanner;
public class Main {
    static int[] arr;
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            // Please write your code here.
            sb.append(bs(x)).append('\n');
        }
        System.out.print(sb);
    }

    public static int bs(int target) {
        int left = 0;
        int right = n-1;
        int answer = -1;
        while(left<=right) {
            int mid = left + (right - left)/2;

            if(arr[mid] == target) {
                answer = mid+1;
                return answer;
            }
            else if(arr[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return answer;
    }
}