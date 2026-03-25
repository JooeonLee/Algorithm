#include<iostream>
#include<string>
using namespace std;
int main(){
	ios_base :: sync_with_stdio(false); 
	cin.tie(NULL); 
	cout.tie(NULL);
	
	bool minusFlag = false;
	string str;
	int temp = 0;
	int answer = 0;
	cin >> str;
	for(int i=0; i<=str.size(); i++){
		if(str[i]=='+' || str[i]=='-' || i==str.size()){
			if(minusFlag)
				answer -= temp;
			else
				answer += temp;
			if(str[i]=='-')
				minusFlag = true;
			temp = 0;
		}
		else{
			temp *= 10;
			temp += str[i] - '0';
		}
	}
	cout << answer << '\n';
	return 0;
}