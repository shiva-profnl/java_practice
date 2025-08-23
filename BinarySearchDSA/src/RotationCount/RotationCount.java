package RotationCount;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {2,1,0};
        int start = 0, end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(mid < end && arr[mid] > arr[mid + 1]) {
                System.out.print(mid + 1);
                return;
            }
                
            if(mid > start && arr[mid] < arr[mid - 1]) {
                System.out.print(mid);
                return;
            }

            if(arr[start] < arr[mid]) {
                start = mid + 1;
            } else end = mid - 1;
        }
        System.out.println(0);
    }
}
