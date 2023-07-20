#include<stdio.h>
int adj[101][101] = {0};
int chk[101][101] = {0};
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};
int max = 0;
int cnt = 0;

int isValid(int y, int x, int ySize, int xSize){
	return 1<=y && y<=ySize && 1<=x && x<=xSize;
}

void dfs(int y, int x, int ySize, int xSize){
	chk[y][x] = 1;
	cnt++;
	int ny, nx;
	for(int i=0; i<4; i++){
		ny = y + dy[i];
		nx = x + dx[i];
		
		if(isValid(ny, nx, ySize, xSize) && adj[ny][nx] == 1 && !chk[ny][nx]){
			dfs(ny, nx, ySize, xSize);
		}
	}
}

int main(){
	int N, M, K, r, c;
	scanf("%d %d %d", &N, &M, &K);
	
	for(int i=0; i<K; i++){
		getchar();
		scanf("%d %d", &r, &c);
		adj[r][c] = 1;
	}
	
	for(int i=1; i<=N; i++){
		for(int j=1; j<=M; j++){
			if(adj[i][j] == 1 && !chk[i][j]){
				cnt = 0;
				dfs(i, j, N, M);
				if(cnt > max)
					max = cnt;
			}
		}
	}
	
	printf("%d\n", max);
	return 0;
}