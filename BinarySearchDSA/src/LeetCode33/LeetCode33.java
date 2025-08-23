package LeetCode33;

public class LeetCode33 {

    // Search function for rotated sorted array
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);
        System.out.println("Pivot: " + pivot);

        if (pivot == -1) // array not rotated
            return binarySearch(nums, 0, nums.length - 1, target);

        if (nums[pivot] == target) 
            return pivot;

        if (nums[0] <= target) 
            return binarySearch(nums, 0, pivot - 1, target);

        return binarySearch(nums, pivot + 1, nums.length - 1, target);
    }

    // Find pivot index (largest element in rotated array)
    int findPivot(int[] arr, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1])
                return mid;
            if (mid > start && arr[mid] < arr[mid - 1])
                return mid - 1;
            if (arr[mid] <= arr[start])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    // Standard binary search
    int binarySearch(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < target)
                start = mid + 1;
            else if (arr[mid] > target)
                end = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    // Main function to test
    public static void main(String[] args) {
        LeetCode33 sol = new LeetCode33();

        int[] nums = {4, 5, 6, 7, 0, 1, 2}; // rotated sorted array
        int target = 0;  // sample target

        int result = sol.search(nums, target);
        System.out.println("Target " + target + " found at index: " + result);
    }
}
