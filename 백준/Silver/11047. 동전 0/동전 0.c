#include<stdio.h>
int main(){
	int coin[10];
	int N, K;
	int count = 0;
	scanf("%d %d", &N, &K);
	
	for(int i = 0; i < N; i++)
		scanf("%d", &coin[i]);
	
	for(int i = N-1; i >= 0; i--){
		if(coin[i] <= K){
			count += (K/coin[i]);
			K %= coin[i];
		}
	}
	
	printf("%d\n", count);
}