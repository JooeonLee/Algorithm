#include<stdio.h>
#include<algorithm>
using namespace std;
int arr[1001][1001];
int maxSqare(int N, int M){
	int ans = 0;
	for(int i=1; i<=N; i++){
		for(int j=1; j<=M; j++){
			if(arr[i][j] == 1)
				arr[i][j] = min({arr[i-1][j], arr[i][j-1], arr[i-1][j-1]}) + 1;
			if(ans < arr[i][j])
				ans = arr[i][j];
		}
	}
	return ans;
}
int main(){
	int N, M, maxlen;
	scanf("%d %d", &N, &M);
	for(int i=1; i<=N; i++){
		for(int j=1; j<=M; j++)
			scanf("%1d", &arr[i][j]);
	}
	maxlen = maxSqare(N, M);
	printf("%d\n", maxlen*maxlen);
	return 0;
}