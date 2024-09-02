#include<stdio.h>
#define MAX_SIZE 301
#define MAX(a, b) a>b?a:b
int climbingStairs(int* arr, int* maxArray, int N){
	maxArray[0] = 0;
	maxArray[1] = arr[1];
	maxArray[2] = arr[1] + arr[2];
	for(int i = 3; i <= N; i++)
		maxArray[i] = arr[i] + (MAX(maxArray[i-3] + arr[i-1], maxArray[i-2]));
	return maxArray[N];
}

int main(){
	int arr[MAX_SIZE];
	int maxArray[MAX_SIZE];
	int N;
	scanf("%d", &N);
	for(int i = 1; i <= N; i++)
		scanf("%d", &arr[i]);
	printf("%d\n", climbingStairs(arr, maxArray, N));
	return 0;
}
