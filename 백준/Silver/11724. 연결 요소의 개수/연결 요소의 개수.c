#include<stdio.h>
#define MAX_SIZE 1001
int adj[MAX_SIZE][MAX_SIZE] = {0};
int chk[MAX_SIZE] = {0};

void dfs(int idx, int size){
	chk[idx] = 1;
	for(int j = 1; j < size + 1; j++){
		if(adj[idx][j] && !chk[j]){
			chk[j] = 1;
			dfs(j, size);
		}
	}
	return;
}

int numOfConnectedComponent(int size){
	int answer = 0;
	for(int i = 1; i < size + 1; i++){
		if(chk[i] == 0){
			chk[i] = 1;
			answer++;
			dfs(i, size);
		}
	}
	return answer;
}

int main(){
	int N, M;
	int idx1, idx2;
	scanf("%d %d", &N, &M);
	for(int i = 0; i < M; i++){
		scanf("%d %d", &idx1, &idx2);
		adj[idx1][idx2] = 1;
		adj[idx2][idx1] = 1;
	}
	printf("%d\n", numOfConnectedComponent(N));
	return 0;
}