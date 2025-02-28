#include<stdio.h>
long long tree[1000001];

long long getTree(int s, long long e, int N, long long M){
	long long left = s, right=e, mid, sum;
	long long upper_bnd = -1;
	
	while(left <= right){
		mid = (left + right) / 2;
		
		sum=0;
		for(int i=0; i<N; i++){
			if(tree[i] > mid)
				sum += (tree[i] - mid);
		}
		
		if(sum >= M){
			upper_bnd = mid;
			left = mid +1;
		}
		else
			right = mid -1;
	}
	return upper_bnd;
}
int main(){
	int N;
    long long M, max;

	scanf("%d %lld", &N, &M);
	max=0;
	for(int i=0; i<N; i++){
		scanf("%lld", &tree[i]);
		
		if(max < tree[i]){
			max = tree[i];
		}
		
	}
	
	printf("%lld\n", getTree(0, max, N, M));
	return 0;
}