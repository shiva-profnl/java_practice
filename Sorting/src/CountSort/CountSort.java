package CountSort;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 0, 2, 3, 0, 3};
        int maxElement = arr[0];
        int n = arr.length;

        for(int x: arr) {
            if(x > maxElement)
                maxElement = x;
        }

        int[] countArray = new int[maxElement+1];

        for(int x: arr) {
            countArray[x]++;
        }

        for(int i=1; i<maxElement+1; i++) {
            countArray[i] += countArray[i-1];
        }

        int[] retArr = new int[n];

        for(int i = n-1; i>0; i--) {
            retArr[--countArray[arr[i]]] = arr[i];
        }

        System.out.println("Sorted Array:" + Arrays.toString(retArr));
    }
}
