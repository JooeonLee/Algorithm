#include<stdio.h>
int dp[31];
int main(){
	int N;
	scanf("%d", &N);
	dp[0] =1;
	dp[2] = 3;
	for(int n=4; n<=30; n+=2){
		for(int i=2; i<=n; i+=2){
			if(i==2)
				dp[n] = dp[n-i] * dp[i];
			else if(n-i >= 0)
				dp[n] += dp[n-i] * 2; 
		}
	}
	
	if(N%2 == 1){
		printf("0\n");
		return 0;
	}
	else{
		printf("%d\n", dp[N]);
		return 0;
	}
}