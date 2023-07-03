#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main(){
  int n;
  cin >> n;
  int p1 =0; //start
  int p2 = n-1; //end
  int min = 2000000001; //min의 초기값을 최로 설정
  vector<int> arr(n);
  for(int i=0; i<n; i++)
    cin >> arr[i];
  sort(arr.begin(), arr.end());
  int answer1, answer2, sum;
  while(p1 < p2){
    sum = arr[p1] + arr[p2];
    if(min > abs(sum)){
      min = abs(sum);
      answer1 = arr[p1];
      answer2 = arr[p2];
    }
    if(sum < 0)
      p1++;
    else
      p2--;
  }
  cout << answer1 << ' '<< answer2 << '\n';
  return 0;
}