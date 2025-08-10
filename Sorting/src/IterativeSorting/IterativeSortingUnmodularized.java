package IterativeSorting;
// import java.util.Arrays;

public class IterativeSortingUnmodularized {
    public static void main(String[] args) throws Exception {
        // int[] inpArr = {5,4,3,2,1}; //sample input 1.

        // System.out.println("Array before bubble sort: "+ Arrays.toString(inpArr));
        // bubbleSort(inpArr);
        // System.out.println("Array after bubble sort: "+ Arrays.toString(inpArr));

        // System.out.println("Array before selection sort: "+ Arrays.toString(inpArr));
        // selectionSort(inpArr)
        // System.out.println("Array after selection sort: "+ Arrays.toString(inpArr));

        // System.out.println("Array before insertion sort: "+ Arrays.toString(inpArr));
        // insertionSort(inpArr)
        // System.out.println("Array after insertion sort: "+ Arrays.toString(inpArr));

        // System.out.println("Array before cyclic sort: "+ Arrays.toString(inpArr));
        // cyclicSort(inpArr)
        // System.out.println("Array after cyclic sort: "+ Arrays.toString(inpArr));

        // int[] inpArr2 = {8, 3, 4, 5, 3, 2, 8, 10, 10, 1};  // sample input 2

        // System.out.println("Array before count sort: "+ Arrays.toString(inpArr2));
        // countSort(inpArr2)
        // System.out.println("Array after count sort: "+ Arrays.toString(inpArr2));

        // int[] inpArr3 = {2, 34, 5, 67, 91, 458, 911, 876}; //sample input 3

        // System.out.println("Array before radix sort: "+ Arrays.toString(inpArr3));
        // radixSort(inpArr3)
        // System.out.println("Array after radix sort: "+ Arrays.toString(inpArr3));
    }

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapCheck; 
        int temp;

        for(int i=0; i<n-1; i++) { 
            // let this run n-1 times, cuz when the second last element is sorted 
            // the last element will automatically be in it's place.
            
            swapCheck = false;
            for(int j=0; j<n-i-1; j++) { // since we are using indices like j+1, 
                // which might not exist when 0, (when i=0, j will run from 0 to n-1, 
                // and in that case, when j=n-1, j+1 will be n, which is the length 
                // of the array)
                if(arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapCheck = true;
                }
            }
            if(!swapCheck) return; // break if there were no swaps
        } 

    }

    static void selectionSort(int[] arr) {
        int temp;
        int n = arr.length;

        for( int i=0; i<n-1; i++) {
            // let this run 'n-1' times, cuz when the second last element is sorted 
            // the last element will automatically be in its place.

            int maxElementIndex = 0; 
            // used to know the index of largest element in the range below for 'j'

            for(int j=0; j<=n-1-i; j++) {
                if(arr[maxElementIndex] < arr[j])
                    maxElementIndex = j;
            }
            
            temp = arr[n-1-i];
            arr[n-1-i] = arr[maxElementIndex];
            arr[maxElementIndex] = temp;
            // swapping the largest element in the range, with the largest index 
            // in the range
        }

        // best case: O(n^2)
        // worst case: O(n^2)
        // stability: unstable
        // inplace sort?: yes
    }

    static void insertionSort(int[] arr) {

        int n = arr.length;
        int temp; // used for swapping

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j>0; j--) {
                if(arr[j]>arr[j-1])
                    break; // the current element is greater than the highest element in
                    // the sorted array to it's left. so it's current position is it's 
                    // appropriate position in the array, which is subject to change when new elements,
                    // possibly lesser than this will be added to it's left.

                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            } 
        }

    }

    static void cyclicSort(int[] arr) {

        int temp; // used for swapping
        int n = arr.length;

        for(int i=0; i<n; i++) {
            if(arr[i] != i+1) {
                temp = arr[i];
                arr[i] = i+1;
                arr[temp-1] = temp;
            }
        }

        // best case: O(n)
        // worst case: O(n)
        // stability: stable
        // inplace sorting?: yes
    }

    static int[] countSort(int[] arr) {
        int n = arr.length;
        int maxElement = arr[0]; // to create count of element array

        for(int i = 0; i<n; i++) {
            if(arr[i]> maxElement)
                maxElement = arr[i]; 
                // get the highest element to create an array in which in the index 
                // represents the number, and the value at that index represent 
                // the count of number of times it appears in the original array
        }

        int[] countArray = new int[maxElement+1]; //above mentioned array is created

        for(int element: arr) {
            countArray[element]++;
        }

        for(int i=1; i<=maxElement; i++) {
            countArray[i]+=countArray[i-1];
        }

        int[] retArr = new int[n]; // new array in which the elements are added

        for(int i=n-1; i>=0; i--) {
            retArr[--countArray[arr[i]]] = arr[i];
        }

        return retArr;
    }

    static int[] radixSort(int[] arr) {

        // step 1: get highest element
        int maxElement = arr[0];
        int n = arr.length;
        int[] retArr = new int[n]; // array to be returned

        for(int i=1; i<n; i++) {
            if(maxElement < arr[i])
                maxElement = arr[i];
        }

        // step 2: run count sort for every digit.
        for(int i=1; i<maxElement; i*=10) {
            int[] countArray = new int[10];
            for(int x: arr) {
                countArray[(x/i)%10]++;
            }

            for(int j=1; j<10; j++) {
                countArray[j] += countArray[j-1];
            }

            for(int j=n-1; j>=0; j--) {
                retArr[--countArray[(arr[j]/i)%10]] = arr[j];
            } // count sort is performed upto this step

            for(int j=0; j<n; j++) {
                arr[j] = retArr[j];
            }
        }

        return retArr;
    }    
}
