package IterativeSorting;
import java.util.Arrays;

public class IterativeSorting
{
    public static void main(String[] args) throws Exception {
        // int[] inpArr = {3,1,2,5,4}; //sample input 1.

        // System.out.println("Array before bubble sort: "+ Arrays.toString(inpArr));
        // System.out.println("Array after bubble sort: "+ Arrays.toString(bubbleSort(inpArr)));

        // System.out.println("Array before selection sort: "+ Arrays.toString(inpArr));
        // System.out.println("Array after selection sort: "+ Arrays.toString(selectionSort(inpArr)));

        // System.out.println("Array before insertion sort: "+ Arrays.toString(inpArr));
        // System.out.println("Array after insertion sort: "+ Arrays.toString(insertionSort(inpArr)));

        // System.out.println("Array before cyclic sort: "+ Arrays.toString(inpArr));
        // System.out.println("Array after cyclic sort: "+ Arrays.toString(cyclicSort(inpArr)));

        // int[] inpArr2 = {8, 3, 4, 5, 3, 2, 8, 10, 10, 1};  // sample input 2

        // System.out.println("Array before count sort: "+ Arrays.toString(inpArr2));
        // System.out.println("Array after count sort: "+ Arrays.toString(countSort(inpArr2)));

        // int[] inpArr3 = {2, 34, 5, 67, 91, 458, 911, 876}; //sample input 3

        // System.out.println("Array before radix sort: "+ Arrays.toString(inpArr3));
        // System.out.println("Array after radix sort: "+ Arrays.toString(radixSort(inpArr3)));
    }

    static int[] bubbleSort(int[] arr) {
        // also known as "sinking sort" or "exchange sort" 
        // optimized in such a way that returns the array if all the elements inside it are sorted.

        int n = arr.length;
        int compareCount = 0; // check no. of comparisons
        boolean swapCheck; 
        // check if there happened any swap in that iteration ( with respect to i)
        int temp; // for swapping two elements

        for(int i=0; i<n-1; i++) { 
            // let this run n-1 times, cuz when the second last element is sorted 
            // the last element will automatically be in it's place.
            
            swapCheck = false; // initially, no swaps will happen in that iteration
            for(int j=0; j<=n-i-1; j++) {
                compareCount++; 
                if(arr[j]>arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapCheck = true; // swap happened, means the array is not yet sorted
                }
            }
            if(!swapCheck) break; // break if there were no swaps
        }
        System.out.print("Total No. of Comparisons:"+compareCount);
        return arr; //return the sorted array

        // best case: O(n)
        // worst case: O(n^2)
        // stabiliity: stable
        // inplace sort?: yes 

    }

    static int[] selectionSort(int[] arr) {
        // selection sort select the lowest/element from the array and 
        // swaps the position of that element 
        // with the element in the lowest/highest index respectively.

        int temp; //used for swapping
        int n = arr.length;

        for( int i=0; i<n-1; i++) {
             //let this run n-1 times, cuz when the second last element is sorted 
            //the last element will automatically be in it's place.

            int maxElementIndex = 0; 
            // used to know the index of largest element in the range below for j

            for(int j=0; j<=n-1-i; j++) {
                if(arr[maxElementIndex] < arr[j])
                    maxElementIndex = j;
            }
            
            temp = arr[n-1-i];
            arr[n-1-i] = arr[maxElementIndex];
            arr[maxElementIndex] = temp;
            //swapping the largest element in the range, with the largest index in the range
        }

        return arr;

        // best case: O(n^2)
        // worst case: O(n^2)
        // stability: unstable
        // inplace sort?: yes
    }

    static int[] insertionSort(int[] arr) {
        //this is an algorithm which insert an element in the appropriate place in a sorted
        //array. this is used in hybrid sorting algorithms, since it performs very less 
        //no. of swap when compared with bubble sort

        int n = arr.length;
        int temp; // used for swapping

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j>0; j--) {
                if(arr[j]>arr[j-1])
                    break; // array to it's left is already sorted

                temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp; // keep swapping to your left until it reaches it's apt position
            } 
        }

        return arr;

        // best case: O(n)
        // worst case: O(n^2)
        // stability: stable
        // inplace sort?: yes 

    }

    static int[] cyclicSort(int[] arr) {
        // Note: when given number is of the range 1 to N, use cyclic sort.

        int temp; // used for swapping
        int n = arr.length;

        for(int i=0; i<n; i++) {
            if(arr[i] != i+1) {
                temp = arr[i];
                arr[i] = i+1;
                arr[temp-1] = temp;
            }
        }
        return arr;

        // best case: O(n)
        // worst case: O(n)
        // stability: stable
        // inplace sorting?: yes
    }

    static int[] countSort(int[] arr) {
        // this element gets the count of element in an array/object and then creates a new array 
        // and adds the element in a new array the same number of times it occurs in the old array

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
            // value of the index is increamented for each occurance in the original array
        }

        for(int i=1; i<=maxElement; i++) {
            countArray[i]+=countArray[i-1];
            // this is to set the index of the elements in place
        }

        int[] retArr = new int[n]; // new array in which the elements are added

        for(int i=n-1; i>=0; i--) {
            retArr[--countArray[arr[i]]] = arr[i];
            // traverse from reverse, since the count array will have 
            // the largest position of the element in it, where
            // the index of the count array represents the element in the original array
            // and the value in the count array represents the number of occurances in the table.
            // so we are adding the elements such that the order of the same elements are preserved by adding 
            // them from right to left. 
        }

        return retArr;

        // best case: O(n)
        // worst case: O(n)
        // stable: yes (because order of the same element in the original array is still preserved)
        // inplace sort?: no, new array is only returned
    }

    static int[] radixSort(int[] arr) {
        // main logic of this algo: sort the array, using count sort
        // sort each element digit by digit, starting from the least signing digit.
        // if there are mismatching numnber of digits, most significant digits of the
        // smaller number is considered zero.

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
            } // after sorting by each digit, our current array after count sort of that digit, 
            // will the base array for the next iteration of count sort.

            System.out.println("Final Array for i="+i+":"+Arrays.toString(retArr));
        }

        return retArr;

        // best case: O(n)
        // worst case: O(n)
        // stability: stable.
        // inplace sort?: no, new array is created
    }    
}
