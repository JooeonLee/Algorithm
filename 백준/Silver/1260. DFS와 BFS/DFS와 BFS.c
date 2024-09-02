#include<stdio.h>
#include<stdlib.h>
#define MAX_SIZE 1001
int adj[MAX_SIZE][MAX_SIZE] = {0};
int chk[MAX_SIZE] = {0};
int adj2[MAX_SIZE][MAX_SIZE] = {0};
int chk2[MAX_SIZE] = {0};

typedef struct{
	int max;
	int num;
	int front;
	int rear;
	int *que;
} IntQueue;

int Init(IntQueue *q, int max){
	q->num = q->front = q->rear = 0;
	if((q->que = calloc(max, sizeof(int))) == NULL){
		q->max = 0;
		return -1;
	}
	q->max = max;
	return 0;
}

int Push(IntQueue *q, int x){
	if(q->num >= q->max)
		return -1;
	else{
		q->num++;
		q->que[q->rear++] = x;
		if(q->rear == q->max)
			q->rear = 0;
		return 0;
	}
}

int Pop(IntQueue *q){
	int x;
	if(q->num <= 0)
		return -1;
	else{
		q->num--;
		x = q->que[q->front++];
		if(q->front == q->max)
			q->front = 0;
		return x;
	}
}

int Size(const IntQueue *q){
	return q->num;
}

int IsEmpty(const IntQueue *q){
	return q->num <= 0;
}

void dfs(int idx, int size){
	chk[idx] = 1;
	for(int j = 1; j < size + 1; j++){
		if(adj[idx][j] && !chk[j]){
			chk[j] = 1;
			printf("%d ", j);
			dfs(j, size);
		}
	}
	return;
}

void bfs(int idx, int size){
	chk2[idx] = 1;
	int curr;
	IntQueue que;
	Init(&que, MAX_SIZE);
	Push(&que, idx);
	while(Size(&que) != 0){
		curr = Pop(&que);
		for(int j = 1; j < size + 1; j++){
			if(adj2[curr][j] && !chk2[j]){
				chk2[j] = 1;
				printf("%d ", j);
				Push(&que, j);
			}
		}
	}
	return;
}
int main(){
	int N, M, startNode;
	int idx1, idx2;
	scanf("%d %d %d", &N, &M, &startNode);
	for(int i = 0; i < M; i++){
		scanf("%d %d", &idx1, &idx2);
		adj[idx1][idx2] = 1;
		adj[idx2][idx1] = 1;
		adj2[idx1][idx2] = 1;
		adj2[idx2][idx1] = 1;
	}
	
	printf("%d ", startNode);
	dfs(startNode, N);
	printf("\n");
	printf("%d ", startNode);
	bfs(startNode, N);
	printf("\n");
	return 0;
}