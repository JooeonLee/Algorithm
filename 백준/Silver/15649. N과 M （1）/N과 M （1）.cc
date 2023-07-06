#include<iostream>
using namespace std;
int n, m;
int arr[10];
int chk[10];

void dfs(int cnt){
    if(cnt == m){
        for(int i = 0; i < m; i++)
            cout << arr[i] << ' ';
        cout << '\n';
        return;
    }
    for(int i = 1; i <= n; i++){
        if(!chk[i]){
            chk[i] = 1;
            arr[cnt] = i;
            dfs(cnt+1);
            chk[i] = 0;
        }
    }
}

int main() {
	ios_base :: sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
    cin >> n >> m;
    dfs(0);
}