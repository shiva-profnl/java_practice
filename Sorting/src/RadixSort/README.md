# Radix Sort:

**Note:** This function will only sort non-negative integers and is adviced to use when the array as numbers range equal to the length of the array and frequency of all the numbers in the array as mentioned before has good amount of frequency.
  
- **Main logic of this algorithm:** sort the array using counting sort for each digit, starting from the least significant digit. If there are mismatching number of digits, most significant digits of the smaller number are considered zero.

- **Input:** Unsorted array of non-negative integers  
- **Output:** New sorted array

- ## Algorithm:
  1. Get the highest element from the array and store it in `maxElement`.
  2. Create an integer `n` as the length of the array.
  3. Create a new integer array `retArr` of size `n` to store intermediate results.
  4. Repeat for each digit place starting from 1 (`i = 1`) and multiplying by 10 until `i <= maxElement`:
     1. Create a `countArray` of size 10 (digits 0–9).
     2. For each element `x` in the array:
        1. Increment `countArray[(x / i) % 10]` by 1.
     3. For each `j` from 1 to 9:
        1. Update `countArray[j] += countArray[j-1]`.
     4. Traverse the array from end to start:
        1. Decrement `countArray[(arr[j] / i) % 10]` by 1 and place the element in `retArr` at that position.
     5. Copy all elements from `retArr` back to `arr`.  
        **Note:** After sorting by each digit, the current array after counting sort becomes the base array for the next digit pass.
  5. Return `retArr`.

- **Best Case Time Complexity:** O(n)  
- **Worst Case Time Complexity:** O(n) 
- **Stability:** Stable  
- **Inplace sort?:** No (Intermediate array is created)