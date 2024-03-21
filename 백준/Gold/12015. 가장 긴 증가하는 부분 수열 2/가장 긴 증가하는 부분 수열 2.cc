#include <bits/stdc++.h>
#define MAX 1000000
using namespace std;


int arr[MAX];
std::deque<int> lisStack; 

int lower_bound(int target) {
    int left = 0;
    int right = lisStack.size() - 1;

    while(left < right) {
        int mid = (left + right) / 2;
        if(lisStack[mid] >= target)
            right = mid;
        else
            left = mid + 1;
    }
    return left;
}

int LIS(int arrSize) {
    int idx;
    for(int i=0; i<arrSize; i++) {
        if(lisStack.empty())
            lisStack.push_back(arr[i]);
        else if(arr[i] > lisStack.back())
            lisStack.push_back(arr[i]);
        else {
            idx = lower_bound(arr[i]);
            lisStack[idx] = arr[i];
        }
    }
    return lisStack.size();
}

int main() {

    int N, lisLength;
    cin >> N;

    for(int i=0; i<N; i++)
        cin >> arr[i];

    lisLength = LIS(N);
    cout << lisLength << '\n';
}