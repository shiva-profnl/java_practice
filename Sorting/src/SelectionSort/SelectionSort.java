package SelectionSort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 5, 22, 11, 90, 12};
        int n = arr.length;

        for(int i=n-1; i>0; i--) {
            for(int j=0; j<i; j++) {
                if(arr[j]>arr[i]) {
                    swap(arr, i, j);
                }
            }
        }

        System.out.println("Sorted Array: "+ Arrays.toString(arr));
        return;
    }

    static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
