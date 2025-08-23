package OrderAgnosticBinarySearch;

import java.util.Arrays;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        // Test cases
        int[][] testArrays = {
            {1, 3, 5, 7, 9, 11, 13},     // ascending
            {-10, -3, 0, 4, 8, 12},      // ascending
            {2, 4, 6, 8, 10},            // ascending
            {20, 17, 15, 13, 10, 5, 2},  // descending
            {100, 50, 25, 12, 6, 3, 1},  // descending
            {9, 7, 5, 3, 1},             // descending
            {5},                         // single element
            {5},                         // single element, target not present
            {2, 2, 2, 2}                 // all same elements
        };

        int[] targets = {7, 0, 11, 13, 50, 10, 5, 2, 2};
        int[] solutions = {3, 2, -1, 3, 1, -1, 0, -1, 1};

        for (int i = 0; i < testArrays.length; i++) {
            int[] arr = testArrays[i];
            int target = targets[i];
            int index = orderAgnosticBinarySearch(arr, target);
            System.out.print("Array: " + Arrays.toString(arr));;
            System.out.println("Target: " + target);
            System.out.println("Result Index: " + index);
            if(index == solutions[i])
                System.out.println("Success!");
            else
                System.out.println("Failure :(");
            System.out.println("----------------------");
        }
    }

    static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[start] <= arr[end]) {
                if(arr[mid] > target) {
                    end = mid - 1;
                } else if(arr[mid] < target) {
                    start = mid + 1;
                } else return mid;
            } else {
                if(arr[mid] < target) {
                    end = mid - 1;
                } else if(arr[mid] > target) {
                    start = mid + 1;
                } else return mid;
            }
        }
        return -1;
    }

}
