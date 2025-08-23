package LeetCode1095;

// Given interface
interface MountainArray {
    public int get(int index);
    public int length();
}

// Implementation class
class MountainArrayImpl implements MountainArray {
    private int[] arr;

    // Constructor to initialize the array
    public MountainArrayImpl(int[] arr) {
        this.arr = arr.clone(); // clone for safety
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= arr.length) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        return arr[index];
    }

    @Override
    public int length() {
        return arr.length;
    }
}

// Example usage
public class LeetCode1095 {
    public static void main(String[] args) {
        int[] mountain = {0, 2, 4, 6, 5, 3, 1};
        MountainArray mountainArray = new MountainArrayImpl(mountain);
        int peakIndex = findPeakIndex(mountainArray);
        int target = 10;

        if(target > mountainArray.get(peakIndex)) {
            System.out.println(-1);
            return;
        } else if(target == mountainArray.get(peakIndex)) {
            System.out.println(peakIndex);
            return;
        } else {
            int ans = orderAgnosticBinarySearch(mountainArray, 0, peakIndex - 1, target);
            if(ans == -1) {
                ans = orderAgnosticBinarySearch(mountainArray, peakIndex + 1, mountainArray.length() - 1, target);
            } 
            System.out.println(ans);
        }
    }

    static int orderAgnosticBinarySearch(MountainArray mountainArr, int start, int end, int target) {
        // return then index of the item if found. else it returns -1
        if(mountainArr.get(start) < mountainArr.get(end)) {
            while(start <= end) {
                int mid = start + (end - start)/2;

                if(mountainArr.get(mid) == target) {
                    return mid;
                } else if(mountainArr.get(mid) > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        } else {
            while(start <= end) {
                int mid = start + (end - start)/2;

                if(mountainArr.get(mid) == target) {
                    return mid;
                } else if(mountainArr.get(mid) < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    static int findPeakIndex(MountainArray mountainArr) {
        int start = 0, end = mountainArr.length() - 1;
        while(start < end) {
            int mid = start + (end = start)/2;

            if(mountainArr.get(mid) > mountainArr.get(mid+1)) {
                end = mid;
            } else start = mid + 1;
        }
        return start;
    }
}
