package ElementPositionInInfiniteSortedArray;

public class ElementPositionInInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = -6;
        int start = 0;
        int end = 1;
        while(arr[end] < target) {
            int newStart = end+1;
            end = newStart + (end - start)*2 + 1;
            start = newStart; 
        }

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] == target) {
                System.out.println(mid);
                return;
            } else if(arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(-1);
        return;
    }
}
