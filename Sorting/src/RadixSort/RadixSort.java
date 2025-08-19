package RadixSort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        int maxElement = arr[0];

        for(int x: arr) {
            if(x>maxElement) {
                maxElement = x;
            }
        }

        int exp = 1;

        while(maxElement>0) {
            arr = countSort(arr, exp, n);
            exp *= 10;
            maxElement /= 10;
        }

        System.out.println(Arrays.toString(arr));
    }

    static int[] countSort(int[] arr, int exp, int n) {
            int[] countArray = new int[10];

            for(int x: arr) {
                countArray[(int)(x/exp)%10]++;
            }

            for(int i=1; i<10; i++) {
                countArray[i] += countArray[i-1];
            }

            int[] retArr = new int[n];

            for(int i = n-1; i>=0; i--) {
                retArr[--countArray[(int)(arr[i]/exp)%10]] = arr[i];
            }

            return retArr;
    }
}
