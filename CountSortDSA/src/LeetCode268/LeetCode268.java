package LeetCode268;

public class LeetCode268{
    public static void main(String[] args) {
        int[] arr = {9,6,4,2,3,5,7,0,1}; // sample input
        int n = arr.length;

        for(int i=0; i<n; i++) {
            while (arr[i] != i) {
                if(arr[i]==n)
                    break; // arr[n] will not exist, so when swap happens, 
                    // let a number lower than this number exchanges its place with 
                    // this element when swap happens.
                swap(arr, i, arr[i] == n ? arr[i] -1 : arr[i]);
            }
        }

        for(int i=0; i<n; i++) {
            if(arr[i]!=i) {
                System.out.println(i); // missing number
                return;
            }
        }

        System.out.println(n); //if elements 0 to n-1 are there,
        //then the above for loop will not return. that means n is the missing number
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}