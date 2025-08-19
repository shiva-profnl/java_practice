package CyclicSort;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int n = arr.length;

        for(int i=0; i<n; i++) {
            while(arr[i]!=i+1) {
                System.out.println("*");
                swap(arr, i, arr[i]-1);
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
