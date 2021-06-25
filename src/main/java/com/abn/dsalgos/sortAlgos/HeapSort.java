package com.abn.dsalgos.sortAlgos;

public class HeapSort {

		 public int[] sort(int arr[]) //sort in ascending order
		    {
		        int n = arr.length;
		        int startIndex = (n-1)/2;
		        for (int i = startIndex; i >= 0; i--) //calling heapify procedure to implement max heap 
		        {
		            heapify(arr, n, i);
		        }
		        for (int i=n-1;i>0;i--) //replacing highest element with smallest element and again call heapify procedure
		        {
		            int temp = arr[0];
		            arr[0] = arr[i];
		            arr[i] = temp;
		            heapify(arr, i, 0);
		        }
		        return arr;
		    }
		 
		    void heapify(int arr[], int n, int i) //heapify procedure for creating max heap 
		    {
		        int largest = i; //initialize largest as root
		        int l = 2 * i + 1; //left child
		        int r = 2 * i + 2; //right child
		
		        if (l < n && arr[l] > arr[largest])
		        {
		            largest = l;
		        }
		     
		        if (r < n && arr[r] > arr[largest])
		        {
		            largest = r;
		        }
		        
		        if (largest != i) //if root is not largest then swap with its child which is larger 
		        {
		            int swap = arr[i];
		            arr[i] = arr[largest];
		            arr[largest] = swap;
		            heapify(arr, n, largest);
		        }
		    }
		 
		    
		    static void printArray(int arr[]) //print function to print the sorted array
		    {
		        int n = arr.length;
		        for (int i = 0; i < n; ++i)
		            System.out.print(arr[i] + " ");
		        System.out.println();
		    }
		 
}


