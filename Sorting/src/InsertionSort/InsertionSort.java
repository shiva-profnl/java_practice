package InsertionSort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int n= arr.length;

        for(int i = 0; i<n-1; i++) {
            for(int j=i+1; j>0; j--) {
                if(arr[j]>arr[j-1])
                    break;
                swap(arr, j, j-1);
            }
        }

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
