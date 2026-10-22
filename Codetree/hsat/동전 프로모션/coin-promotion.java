import java.util.*;

/**
dp[i][j] : 
i: i번째 동전 확인
j: j만큼의 돈
*/
public class Main {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[] cType = new char[n+1];
        int[] coin = new int[n+1];
        for (int i = 1; i <= n; i++) {
            cType[i] = sc.next().charAt(0);
            coin[i] = sc.nextInt();
        }
        // Please write your code here.
        // int[][] dp = new int[n+1][m+1];
        // for(int i=0; i<=n; i++)
        //     Arrays.fill(dp[i], Integer.MAX_VALUE);
        // dp[0][0] = 0;

        // for(int i=1; i<=n; i++) {
        //     int currCoin = coin[i];
        //     for(int amount=0; amount<=m; amount++) {
        //         // 현재 동전 선택 안함
        //         dp[i][amount] = dp[i-1][amount];

        //         // 현재 동전 선택할 때 이전 상태 확인할 수 없다면
        //         if(amount < currCoin)
        //             continue;

        //         // 이전 동전 확인
        //         // A 무한 냅색
        //         // B 0/1 냅색
        //         int prev = cType[i]=='A' ? dp[i][amount-currCoin] : dp[i-1][amount-currCoin];
        //         if(prev != INF)
        //             dp[i][amount] = Math.min(dp[i][amount], prev+1);
        //     }
        // }
        int[] dp = new int[m+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i=1; i<=n; i++) {
            int currCoin = coin[i];
            char currType = cType[i];
            if(currType == 'A') {
                for(int amount=currCoin; amount<=m; amount++) {
                    int prev = dp[amount-currCoin];
                    if(prev==INF)
                        continue;
                    dp[amount] = Math.min(dp[amount], prev+1);   
                }
            }
            else {
                for(int amount=m; amount>=currCoin; amount--) {
                    int prev = dp[amount-currCoin];
                    if(prev==INF)
                        continue;
                    dp[amount] = Math.min(dp[amount], prev+1);
                }
            }
        }
        int answer = dp[m]==INF ? -1 : dp[m];
        System.out.print(answer);
    }
}