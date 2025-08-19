package BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        boolean swapped;
        int n = arr.length;

        for(int i=0; i<n-1; i++) {
            swapped = false;
            for(int j=0; j<n-i-1; j++) {
                if(arr[j]>arr[j+1]) {
                    swap(arr, j);
                    swapped = true;
                    System.out.println("Array: "+ Arrays.toString(arr));
                }
            }

            if(!swapped){
                break;
            }
        }
        
        System.out.println("Sorted Array: "+ Arrays.toString(arr));
        return;
    }

    static void swap(int[] arr, int index) {
        int temp = arr[index];
        arr[index] = arr[index+1];
        arr[index+1] = temp;
    }
}