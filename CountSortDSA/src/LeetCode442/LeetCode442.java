package LeetCode442;

public class LeetCode442{
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1}; // sample input
        int n = arr.length;

        for(int i=0; i<n; i++) {
            while (arr[i] != i+1) {
                if(arr[arr[i] - 1] == arr[i]) break; // means the element's copy is already in place. 
                // so this will prevent endless loop where exchanging two copies of element, where an element
                // is already there in it's place, but element that should be there in it's in current place 
                // is not there in the array itself
                swap(arr, i, arr[i]-1);
            }
        }

        for(int i=0; i<n; i++) {
            if(arr[i] != i+1)
                System.out.println(arr[i]); // duplicate element
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}