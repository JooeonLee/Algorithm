#include <stdio.h>
void StarPrint(int x, int y, int num){
	if((x/num)%3==1 && (y/num)%3==1)
		printf(" ");
	else if(num/3==0)
		printf("*");
	else
		StarPrint(x, y, num/3);
}


int main(){
	int num1, i, j, num2;
	num2=1;
	scanf("%d", &num1);
	
	for(i=0; i<num1; i++){
		for(j=0; j<num1; j++)
			StarPrint(i, j, num1);
		printf("\n");
	}
	return 0;
}