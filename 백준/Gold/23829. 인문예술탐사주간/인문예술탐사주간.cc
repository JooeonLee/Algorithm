#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, Q;

    cin >> N >> Q;
    
    vector<int> tree(N);
    vector<long long> sumTree(N);
    vector<long long> picture(Q);

    for(int i = 0; i<N; i++)
        cin >> tree[i];
    for(int i = 0; i<Q; i++)
        cin >> picture[i];

    sort(tree.begin(), tree.end());

    sumTree[0] = tree[0];
    for(int i=1; i<N; i++)
        sumTree[i] = sumTree[i-1] + tree[i];

    for(int i=0; i<Q; i++) {
        int tyIdx;
        long long sum=0;
        tyIdx = lower_bound(tree.begin(), tree.end(), picture[i]) - tree.begin();

        if(tyIdx > 0)
            sum = (picture[i] * tyIdx - sumTree[tyIdx-1]) + ((sumTree[N-1] - sumTree[tyIdx-1]) - picture[i]*(N-tyIdx));
        else
            sum = sumTree[N-1] - picture[i]*N;

        cout << sum << '\n';
    }
}