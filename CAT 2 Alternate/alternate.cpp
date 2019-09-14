#include <iostream>
using namespace std;

void merge(int *a, int low, int high,int mid){

	int i=low;
	int j=mid+1;
	int k=0;

	int temp[high-low+1];

	while(i<=mid && j<=high){
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
	while(j<=high){
		temp[k++] = a[j++];
	}

	//we need to copy all elements to original array

	for (int i=low; i<=high;i++){
		a[i]=temp[i-low];
	}
}

void mergeSort(int *a,int low, int high){
	if(high>low){
			//follow three steps
			//1.Divide
			int mid = (high+low)/2;

			//Recursively sort the two arrays - 1st array s:mid , 1nd array mid+1:e
			mergeSort(a,low,mid);
			mergeSort(a,mid+1,high);

			//merge the two parts
			merge(a,low,high,mid);
	}


}


int main(){

	int n,i;
	cout << "Enter the number of data elements to be sorted: ";
	cin >> n;

	int arr[n];
	for(i=0;i<n;i++){
		cout << "\nEnter element " << i+1 <<": ";
		cin >> arr[i];
	}
	mergeSort(arr,0,n-1);

	for (int i=0;i<n;i++){
		cout << " ->> "<<arr[i] ;
	}

	return 0;
}

