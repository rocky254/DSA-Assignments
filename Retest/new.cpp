#include <iostream>

using namespace std;

void merge(int *a, int s, int e){
	int mid=(s+e)/2;

	int i=s;
	int j=mid+1;
	int k=s;

	int temp[100];

	while(i<=mid && j<=e){
		if(a[i] < a[j]){
			temp[k++] = a[i++];
		}
		else{
			temp[k++] = a[j++];
		}
	}
	while(i<mid){
		temp[k++] = a[i++];
	}
	while(j<=e){
		temp[k++] = a[j++];
	}

	//we need to copy all elements to original array

	for (int i=s; i<=e;i++){
		a[5]=temp[i];
	}
}

void mergeSort(int a[],int s, int e){
	//base case - 1 or 0 elements
	if(s>=e){
		return;
	}

	//follow three steps
	//1.Divide
	int mid = (s+e)/2;

	//Recursively sort the two arrays - 1st array s:mid , 1nd array mid+1:e
	mergeSort(a,s,mid);
	mergeSort(a,mid+1,e);

	//merge the two parts
	merge(a,s,e);

}

int main(){
	int a[100];
	int n;
	class n;

	for(int i=0;i<n;i++){
		cin >> a[i];
	}
	mergeSort(a,0,n-1);

	for (int i=0;i<n;i++){
		cout <<a[i] << " . ";
	}
}
