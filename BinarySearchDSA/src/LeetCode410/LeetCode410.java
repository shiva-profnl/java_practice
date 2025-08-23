package LeetCode410;

public class LeetCode410 {
    public static void main(String[] args) {

        int[] nums1 = {7, 2, 5, 10, 8};
        int k1 = 2;
        System.out.println("Input: [7,2,5,10,8], k = 2");
        System.out.println("Output: " + splitArray(nums1, k1));

        int[] nums2 = {1, 2, 3, 4, 5};
        int k2 = 2;
        System.out.println("Input: [1,2,3,4,5], k = 2");
        System.out.println("Output: " + splitArray(nums2, k2));
    }

    static int splitArray(int[] nums, int k) {
        //get the max element simultaneously finding the sum of the array
        int min = nums[0], max = nums[0], n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > min)
                min = nums[i];
            max += nums[i];
        }

        if (k == nums.length)
            return min;
        if (k == 1)
            return max;

        while (min < max) {
            int mid = min + (max - min) / 2;
            int pieces = 1;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    pieces += 1;
                    sum = nums[i];
                } else sum += nums[i];
            }

            if (pieces <= k)
                max = mid;
            else min = mid + 1;
        }
        return max;
    }
}