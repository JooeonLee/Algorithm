#include<stdio.h>
#include<iostream>
#include<string>
#include<vector>
using namespace std;
char adj[101][101];
int chk[101][101];
int dy[4] = {1, 0, -1, 0};
int dx[4] = {0, 1, 0, -1};
int cnt = 0;

bool isValid(int yIdx, int xIdx, int size){
	return (yIdx>=0 && yIdx<size) && (xIdx>=0 && xIdx<size);
}
void InitChk(int size){
	for(int i=0; i<size; i++){
		for(int j=0; j<size; j++)
			chk[i][j] = 0;
	}
	return;
}
void dfs(int yIdx, int xIdx, int size){
	chk[yIdx][xIdx] = 1;
	int ny, nx;
	char currColor = adj[yIdx][xIdx];
	for(int i=0; i<4; i++){
		ny = yIdx + dy[i];
		nx = xIdx + dx[i];
		if(isValid(ny, nx, size) && adj[ny][nx]==currColor && !chk[ny][nx])
			dfs(ny, nx, size);
	}
	return;
}
void RedGreenBlindnessDfs(int yIdx, int xIdx, int size){
	chk[yIdx][xIdx] = 1;
	int ny, nx;
	char currColor = adj[yIdx][xIdx];
	for(int i=0; i<4; i++){
		ny = yIdx + dy[i];
		nx = xIdx + dx[i];
		if(currColor=='B'){
			if(isValid(ny, nx, size) && adj[ny][nx]=='B' && !chk[ny][nx])
				RedGreenBlindnessDfs(ny, nx, size);
		}
		else if(currColor=='R' || currColor=='G'){
			if(isValid(ny, nx, size) && (adj[ny][nx]=='R' || adj[ny][nx]=='G') && !chk[ny][nx])
				RedGreenBlindnessDfs(ny, nx, size);
		}
	}
	return;
}
void dfsAll(int size){
	InitChk(size);
	for(int i=0; i<size; i++){
		for(int j=0; j<size; j++){
			if(chk[i][j] == 0){
				cnt++;
				dfs(i, j, size);
			}
		}
	}
	cout << cnt << " ";
	InitChk(size);
	cnt = 0;
	for(int i=0; i<size; i++){
		for(int j=0; j<size; j++){
			if(chk[i][j] == 0){
				cnt++;
				RedGreenBlindnessDfs(i, j, size);
			}
		}
	}
	cout << cnt << endl;
	return;
}

int main(){
	int N;
	scanf("%d", &N);
	for(int i=0; i<N; i++)
		scanf("%s", adj[i]);
	dfsAll(N);
	return 0;
}