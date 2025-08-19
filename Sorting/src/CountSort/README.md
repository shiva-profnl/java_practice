# Counting Sort:

**Note:** This function will only sort non-negative integers and is adviced to use when the array as numbers range equal to the length of the array and frequency of all the numbers in the array as mentioned before has good amount of frequency.

- **Functionality:** This algorithm gets the count of each element in an array/object, then creates a new array and adds the element in the new array the same number of times it occurs in the old array.

- **Input:** Unsorted array  
- **Output:** New sorted array

- ## Algorithm:
  1. Declare an integer `n` as the length of the array.
  2. Declare an integer `maxElement` and assign it to the value of element at index returned by the Max Element Index utility function. 
  3. Create an integer array `countArray` of size `maxElement+1`. This will store the count of elements. Assign all the values of its elements to be 0,
  4. For each element in the original array:
     1. Increment `countArray[element]` by 1.  
        **Note:** The value at an index is incremented for each occurrence in the original array. (Index -> element in the OG array, value -> count of occurance in the OG array)
  5. For each `i` from 1 to `maxElement`:
     1. Update `countArray[i] += countArray[i-1]`.  
        **Note:** This is to set the index of the elements in place.
  7. Create a new integer array `retArr` of size `n`.
  8. Traverse the original array from end to start (`i = n-1` to `0`):
     1. Decrement `countArray[arr[i]]` by 1 and use that index to place the element in `retArr`.  
        **Note:** We traverse in reverse because the count array stores the largest position of the element in it. The index of the count array represents the element, and the value in the count array represents its occurrence count. Adding elements from right to left preserves the order of duplicate elements (stability).
  9. Return `retArr`.

- **Best Case Time Complexity:** O(n)  
- **Worst Case Time Complexity:** O(n)  
- **Stability:** Stable (order of same elements is preserved)  
- **Inplace sort?:** No (New array is returned)
