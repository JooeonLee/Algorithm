#include<stdio.h>
#include<stdlib.h>
typedef struct Node{
	int idx; //플레이어의 위치
	int cost; //지금까지 주사위를 던진 횟수을 저장
} node;

typedef struct{
	int max;
	int num;
	int front;
	int rear;
	node *que;
} NodeQueue;

int Init(NodeQueue *q, int max){
	q->num = q->front = q->rear = 0;
	if((q->que = calloc(max, sizeof(node))) == NULL){
		q->max = 0;
		return -1;
	}
	q->max = max;
	return 0;
}

int Push(NodeQueue *q, node x){
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

void Pop(NodeQueue *q, node *x){
	if(q->num <= 0)
		return;
	else{
		q->num--;
		*x = q->que[q->front++];
		if(q->front == q->max)
			q->front = 0;
		return;
	}
}

int Size(const NodeQueue *q){
	return q->num;
}

int IsEmpty(const NodeQueue *q){
	return q->num <= 0;
}

int chk[101] = {0};
int board[101] = {0};

void bfs(NodeQueue *q){
	node curr = {1, 0};
	node next;
	Push(q, curr);
	chk[curr.idx] = 1;
	while(!IsEmpty(q)){
		Pop(q, &curr);
		if(curr.idx == 100){
			printf("%d\n", curr.cost);
			break;
		}
		
		for(int i = 1; i <= 6; i++){
			next.idx = curr.idx + i;
			next.cost = curr.cost + 1;
			if(board[next.idx] != 0){  //주사위를 던진위치에 사다리나 뱀이 있다면
				int tmp = board[next.idx];
				next.idx = tmp;
			}
			if(next.idx <= 100 && !chk[next.idx]){
				Push(q, next);
				chk[next.idx] = 1;
			}
		}
	}
}

int main(){
	int N, M;
	NodeQueue que;
	Init(&que, 600);
	scanf("%d %d", &N, &M);
	for(int i = 0; i < N; i++){
		int x, y;
		scanf("%d %d", &x, &y);
		board[x] = y;
	}
	for(int i = 0; i < M; i++){
		int u, v;
		scanf("%d %d", &u, &v);
		board[u] = v;
	}
	bfs(&que);
	return 0;
}