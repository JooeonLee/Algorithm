#include<iostream>
#include<algorithm>
using namespace std;
//인접행렬
int adj[101][101];

void findRoute(int size){
	//플로이드 워셜 알고리즘 적용
	for(int middleNode=0; middleNode<size; middleNode++){
		for(int startNode=0; startNode<size; startNode++){
			for(int endNode=0; endNode<size; endNode++){
				if(adj[startNode][endNode]!=1 && adj[startNode][middleNode]==1 && adj[middleNode][endNode]==1)
					adj[startNode][endNode] = 1;
			}
		}
	}
	return;
}

int main(){
	int N;
	cin >> N;
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++)
			cin >> adj[i][j];
	}
	findRoute(N);
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++)
			cout << adj[i][j] << " ";
		cout << endl;
	}
	return 0;
}