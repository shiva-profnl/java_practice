package LeetCode41;

public class LeetCode41{
    public static void main(String[] args) {
        int[] arr = {7,8,9,11,12}; // sample input
        int n = arr.length;

        for(int i=0; i<n; i++) {
            while(arr[i]!=i+1) {
                if(arr[i]>n || arr[i]<1) // that element is a random value, 
                // which is in place of the missing positive number, so let it 
                // retain its index
                    break;
                swap(arr, i, arr[i] - 1); // else swap the element to its
                //appropriate index
            }
        }

        for(int i=0; i<n; i++) {
            if(arr[i]>n || arr[i]<1) {
                System.out.println(i+1); //first missing positive integer from left
                return;
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}