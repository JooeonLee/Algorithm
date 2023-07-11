#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
int inorder[100001];
int postorder[100001];
int inorderIdx[100001];
//vector<int> inorder;
//vector<int> postorder;

void printPreOrder(int iLeft, int iRight, int pLeft, int pRight){
	//트리에 포함된 노드수
	int N = iRight - iLeft + 1;
	//base case
	if(N == 0) return;
	//트리의 루트
	int root = postorder[pRight];
    //중위순회에서 루트의 인덱스
	int rootIdx = inorderIdx[root];
	// 왼쪽 서브트리의 크기
    int L = rootIdx - iLeft; 
	//전위 순회이므로 루트를 먼저 출력
	cout << root << " ";
	//왼쪽과 오른쪽 서브트리의 순회결과 출력
	printPreOrder(iLeft, rootIdx-1, pLeft, pLeft+L-1);
	printPreOrder(rootIdx+1, iRight, pLeft+L, pRight-1);
	return;
}

int main(){
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	int n, num;
	cin >> n;
	for(int i=1; i<=n; i++){
		cin >> num;
		inorder[i] = num;
	}
	for(int i=1; i<=n; i++){
		cin >> num;
		postorder[i] = num;
	}
	for(int i=1; i<=n; i++)
		inorderIdx[inorder[i]] = i;
	
	printPreOrder(1, n, 1, n);
	cout << endl;
	return 0;
}