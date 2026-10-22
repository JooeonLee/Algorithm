import java.util.Scanner;
public class Main {
    static int MOD = 1_000_000_007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        long[] dp = new long[1001];
        long[] exp = new long[1001];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;
        exp[0] = 0;
        exp[1] = 2;
        exp[2] = 6;

        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1]*2%MOD + dp[i-2] + exp[i-1])%MOD;
            exp[i] = exp[i-1] + dp[i-1]*2;
        }
        System.out.println(dp[n]);
    }
}