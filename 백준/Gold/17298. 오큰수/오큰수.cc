#include<iostream>
#include<stack>
using namespace std;
int arr[1000000];
int main(){
	int N;
	stack<int> idxStk;
	cin >> N;
    
	for(int i=0; i<N; i++){
		cin >> arr[i];
		while(1){
			if(!idxStk.empty()){
				if(arr[i] <= arr[idxStk.top()]){
					idxStk.push(i);
					break;
				}
				else{
					arr[idxStk.top()] = arr[i];
					idxStk.pop();
				}
			}
			else{
				idxStk.push(i);
				break;
			}
		}
	}
	while(!idxStk.empty()){
		arr[idxStk.top()] = -1;
		idxStk.pop();
	}
	for(int i=0; i<N; i++){
		cout << arr[i] << " ";
	}
	cout << endl;
	
	return 0;
}