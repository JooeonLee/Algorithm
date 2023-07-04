#include<iostream>
#include<algorithm>
#include<vector>
#define MAX_SIZE 100001
using namespace std;
int idx1, idx2;
vector<int> adjlist[MAX_SIZE];
int chk[MAX_SIZE];
int ans[MAX_SIZE];
int cnt=0;

void dfs(int idx){
  if(chk[idx] == 1)
    return;
  chk[idx] = 1;
  cnt++;
  ans[idx] = cnt;
  for(int i=0; i<adjlist[idx].size(); i++){
    dfs(adjlist[idx][i]);
  }
}

int main(){
  int N, M, R;
  int idx1, idx2;
  cin >> N >> M >> R;
  for(int i=1; i<=M; i++){
    cin >> idx1 >> idx2;
    adjlist[idx1].push_back(idx2);
    adjlist[idx2].push_back(idx1);
  }
  for(int i=1; i<=N; i++){
    sort(adjlist[i].begin(), adjlist[i].end());
  }
  dfs(R);
  for(int i=1; i<=N; i++){
    cout << ans[i] << '\n';
  }
  return 0;
}