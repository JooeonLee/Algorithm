#include<stdio.h>
#include<queue>
#include<tuple>
using namespace std;
int board[101][101][101];
int chk[101][101][101];
int dz[6] = {0, 0, 0, 0, 1, -1};
int dy[6] = {1 ,0, -1, 0, 0, 0};
int dx[6] = {0, 1, 0, -1, 0, 0};

int isValid(int z, int y, int x, int H, int N, int M){
	return (0 <= z) && (z < H) && (0 <= y) && (y < N) && (0 <= x) && (x < M);
}


void bfs(queue<tuple<int, int, int>>& q, int H, int N, int M){
	tuple<int, int, int> curr;
	tuple<int, int, int> next;
	while(!q.empty()){
		curr = q.front();
		q.pop();
		
		for(int i = 0; i < 6; i++){
			int nz = dz[i] + get<0>(curr);
			int ny = dy[i] + get<1>(curr);
			int nx = dx[i] + get<2>(curr); 
			if(isValid(nz, ny, nx, H, N, M) && (board[nz][ny][nx] == 0) && !chk[nz][ny][nx]){
				chk[nz][ny][nx] = 1;
				board[nz][ny][nx] = board[get<0>(curr)][get<1>(curr)][get<2>(curr)] + 1;
				next = make_tuple(nz, ny, nx);
				q.push(next);
			}
		}
	}
	return;
}

int main(){
	int H, N, M;
	int answer = 0;
	queue<tuple<int, int, int>> q;
	scanf("%d %d %d", &M, &N, &H);
	
	//tomato board 입력
	for(int i = 0; i < H; i++){
		for(int j = 0; j < N; j++){
			for(int k = 0; k < M; k++){
				scanf("%d", &board[i][j][k]);
				
				if(board[i][j][k] == 1){
					q.push(make_tuple(i, j, k));
					chk[i][j][k] = 1;
				}
			}
		}
	}
	
	bfs(q, H, N, M);
	
	for(int i = 0; i < H; i++){
		for(int j = 0; j < N; j++){
			for(int k = 0; k < M; k++){
				if(board[i][j][k] == 0){
					printf("-1\n");
					return 0;
				}
				else if(answer < board[i][j][k])
					answer = board[i][j][k];
			}
		}
	}
	
	printf("%d\n", answer - 1);
	return 0;
}