#include<stdio.h>
#include<iostream>
#include<string>
using namespace std;
int arr[64][64];
bool isWhite(int startY, int startX, int size){
	for(int i=0; i<size; i++){
		for(int j=0; j<size; j++){
			if(arr[startY+i][startX+j] != 0){
				return false;
			}
		}
	}
	return true;
}

bool isBlack(int startY, int startX, int size){
	for(int i=0; i<size; i++){
		for(int j=0; j<size; j++){
			if(arr[startY+i][startX+j] != 1){
				return false;
			}
		}
	}
	return true;
}

string QuadTree(int startY, int startX, int size){
	//base case
	if(isWhite(startY, startX, size))
		return string("0");
	else if(isBlack(startY, startX, size))
		return string("1");
	else{
		int half = size/2;
		string upperLeft = QuadTree(startY, startX, half);
		string upperRight = QuadTree(startY, startX+half, half);
		string lowerLeft = QuadTree(startY+half, startX, half);
		string lowerRight = QuadTree(startY+half, startX+half, half);
		return string("(") + upperLeft + upperRight + lowerLeft + lowerRight + string(")");
	}
}

int main(){
	int N;
	scanf("%d", &N);
	for(int i=0; i<N; i++){
		for(int j=0; j<N; j++)
			scanf("%1d", &arr[i][j]);
	}
	cout << QuadTree(0, 0, N) << endl;
	return 0;
}