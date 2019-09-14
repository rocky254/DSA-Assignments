#include <stdio.h>
#define MAX 5

int main(){
	int array[MAX]={1,2,4,5};
	int N=4;
	int i=0;
	int index=2;
	int value=3;

	printf("The original array elements are: \n");

	for(i=0;i<N;i++){
		printf("array[%d] = %d \n",i,array[i]);
	}

	//shift elements downwards
	for(i=N;i>=index;i--){
		array[i+1]=array[i];
	}

	//add new element at first position
	array[index]=value;

	//increase N to reflect all numbers
	N++;

	printf("The final array elements are: \n");

	for(i=0;i<N;i++){
		printf("array[%d] = %d \n",i,array[i]);
	}

}
