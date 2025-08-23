package BinarySearch2DArray;

import java.util.Arrays;

public class BinarySearch2DArray {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        double target = 13.9;
        
        int mStart = 0, nStart = 0, mEnd = arr.length - 1, nEnd = arr[0].length - 1;

        while(mStart <= mEnd) {
            int mMid = mStart + (mEnd - mStart)/2;

            if(arr[mMid][nStart] > target) {
                mEnd = mMid - 1;
            } else if(arr[mMid][nStart] < target) {
                mStart = mMid + 1;
            } else {
                System.out.println("Answer:"+Arrays.toString(new int[]{mMid, nStart}));
                return;
            }
        }

        while (nStart <= nEnd && mEnd >= 0) {
            int nMid = nStart + (nEnd - nStart)/2;

            if(arr[mEnd][nMid] < target) {
                nStart = nMid + 1;
            } else if(arr[mEnd][nMid] > target) {
                nEnd = nMid - 1;
            } else {
                System.out.println("Answer:"+Arrays.toString(new int[]{mEnd, nMid}));
                return;
            }
        }

        System.out.println("Not found");
    }
}
