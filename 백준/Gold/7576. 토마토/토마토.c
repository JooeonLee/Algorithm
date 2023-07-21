#include<stdio.h>
#include<stdlib.h>

int board[1000][1000] = {0};
int chk[1000][1000] = {0};
int dy[4] = {0, 1, 0, -1};
int dx[4] = {1, 0, -1, 0};

//인접행렬에서의 인덱스 y, x가 유효한 인덱스인지를 판단하는 함수
int isValid(int y, int x, int N, int M){
	return (0 <= y) && (y < N) && (0 <= x) && (x < M);
}

typedef struct{
	int y;
	int x;
} Node;

typedef struct{
	int max;
	int num;
	int front;
	int rear;
	Node *que;
} NodeQueue;

int Init(NodeQueue *q, int max){
	q->num = q->front = q->rear = 0;
	if((q->que = calloc(max, sizeof(Node))) == NULL){
		q->max = 0;
		return -1;
	}
	q->max = max;
	return 0;
}

int Push(NodeQueue *q, Node x){
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

void Pop(NodeQueue *q, Node *x){
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

void bfs(NodeQueue *q, int N, int M){
	Node curr;
	Node next;
	while(!IsEmpty(q)){
		//printf("-------------------------\n");
		Pop(q, &curr);
		
		for(int i = 0; i < 4; i++){
			next.y = curr.y + dy[i];
			next.x = curr.x + dx[i];
			if(isValid(next.y, next.x, N, M) && (board[next.y][next.x] == 0) && !chk[next.y][next.x]){
				//printf("ny, nx = %d, %d\n", next.y, next.x);
				chk[next.y][next.x] = 1;
				board[next.y][next.x] = board[curr.y][curr.x] + 1;
				Push(q, next);
			}
		}
	}
}

int main(){
	int N, M;
	int answer = 0;
	NodeQueue q;
	Node start;
	scanf("%d %d", &M, &N);
	Init(&q, N*M);
	
	//tomato board 입력
	for(int i = 0; i < N; i++){
		for(int j = 0; j < M; j++){
			scanf("%d", &board[i][j]);
			
			if(board[i][j] == 1){
				start.y = i;
				start.x = j;
				Push(&q, start);
				chk[i][j] = 1;
			}
		}
	}
	
	//너비우선탐색 실행
	bfs(&q, N, M);
	
	for(int i = 0; i < N; i++){
		for(int j = 0; j < M; j++){
			if(board[i][j] == 0){
				printf("-1\n");
				return 0;
			}
			else if(answer < board[i][j])
				answer = board[i][j];
		}
	}
	
	printf("%d\n", answer - 1);
	return 0;
}