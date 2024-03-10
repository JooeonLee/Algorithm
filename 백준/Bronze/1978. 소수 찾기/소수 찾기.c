#include<stdio.h>
#include<stdlib.h>
int PrimeNumber(int arr[]){
	int n,i;
	int idx=0;
	arr[0]=2;
	for(n=2; n<=1000; n++){
		for(i=2; i<n; i++){
			if(n%i==0)
				break;
		}
		if(n==i){
			arr[idx++]=n;
		}
	}
	
	return idx;
}

int main(){
	int num,idx,count=0;
	int i,j;
	scanf("%d", &num);
	int* inputArr=calloc(num, sizeof(int));
	int arr[500];
	
	for(i=0; i<num; i++){
		scanf("%d", &inputArr[i]);
	}
	
	idx=PrimeNumber(arr);
	
	for(i=0; i<num; i++){
		for(j=0; j<idx; j++){
			if(inputArr[i]==arr[j]){
				count++;
				break;
			}
		}
	}
	
	printf("%d\n", count);
	return 0;
}