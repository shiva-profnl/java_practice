package LeetCode34;

import java.util.Arrays;

public class LeetCode34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] arr = new int[2];
        arr[0] = searchParticularPosition(nums, target, true);
        arr[1] = -1;
        if(arr[0] != -1) {
           arr[1] = searchParticularPosition(nums, target, false);
        }
        System.out.println("First and last position of an element in the array: " + Arrays.toString(arr));
    }

    static int searchParticularPosition(int[] arr, int target, boolean isFirstPosition) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        int mid;

        while(start <= end) {
            mid = start + (end - start)/2;

            if(arr[mid] == target) {
                ans = mid;
                if(isFirstPosition){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
