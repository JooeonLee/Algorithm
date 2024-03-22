#include <bits/stdc++.h>

#define MAX 10001
using namespace std;
int arr[MAX];

int main() {
    ios::sync_with_stdio(false);
	cin.tie(0);
    cout.tie(0);

    int N, i, j;
    long long total;
    total = 0;
    cin >> N;

    for(int i=0; i<N; i++)
        cin >> arr[i];
    
    sort(arr, arr+N);

    for(int i=0; i<N-2; i++) {
        for(int j=i+1; j<N-1; j++) {
            int s = lower_bound(arr+j+1, arr+N, -(arr[i]+arr[j])) - arr;
            int e = upper_bound(arr+j+1, arr+N, -(arr[i]+arr[j])) - arr;  
            total += e - s;
        }
    }
    cout << total;
}