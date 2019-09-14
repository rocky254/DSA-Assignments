#include <stdio.h>

int main(){
	int a,b,c;
	printf("Enter the three numbers:");
	scanf("%d%d%d",&a,&b,&c);
	int max = a;
	if (b>max){
		max=b;
	}
	if (c>max){
		max=c;
	}
	printf("max = %d",max);
}
