#include <bits/stdc++.h>
using namespace std;

const int MAX = 200001;
const int INF = 0x3f3f3f3f;

int arr[MAX];
int dp[MAX][4];

int main () {
    int N,result;

    cin >> N;
    arr[0] = 0;
    for(int i=1; i<N+1; i++)
        cin >> arr[i];
    
    dp[1][0] = arr[1];
    dp[1][1] = -INF;
    dp[1][2] = -INF;
    dp[1][3] = 2 * arr[1];

    for(int i=2; i<N+1; i++) {
        dp[i][0] = max(dp[i-1][0], dp[i-1][1]) + arr[i];
        dp[i][1] = dp[i-1][2] + 2 * arr[i];
        dp[i][2] = dp[i-1][3] + 2 * arr[i];
        dp[i][3] = max(dp[i-1][0], dp[i-1][1]) + 2 * arr[i];
    }

    result = -INF;
    for(int i=0; i<4; i++) 
        result = max(result, dp[N][i]);
    
    cout << result << '\n';
}