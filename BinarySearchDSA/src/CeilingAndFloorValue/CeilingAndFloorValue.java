package CeilingAndFloorValue;

public class CeilingAndFloorValue {
    public static void main(String[] args) {
        int[] arr = {-18, 12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = -90;
        int ans1 = ceiling(arr, target);
        int ans2 = floor(arr, target);
        System.out.println(ans1 != -1 ? "Ceiling of " + target + ": " + arr[ans1] : "Given array has no ceiling value for the target");
        System.out.println(ans2 != -1 ? "Floor of " + target + ": " + arr[ans2] : "Given array has no floor value for the target");
    }

    static int ceiling(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;
        if(arr[end] < target)
            return -1;
        while(start <= end) {
            int mid = (int)(start + ((end - start)/2));

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length -1;
        if(arr[start] > target)
            return -1;
        while(start <= end) {
            int mid = (int)(start + ((end - start)/2));

            if(arr[mid] == target) {
                return mid;
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }
}
