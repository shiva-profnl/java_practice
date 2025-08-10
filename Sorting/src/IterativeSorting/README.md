# Sorting functions:

**Note:** All these sorting functions are assumed in such a way that the goal is sort all the elements in ascending order

## Bubble Sort:

  - Also known as "Sinking Sort" or "Exchange Sort".

  - Functionality: Swaps the value of two adjacent indices if in element at the lower index is greater than the element at the higher index. If no swap happens in an iteration, then the algorithm understands that the array is sorted and ends.

  - Input: Unsorted array
  - Output: Input array will be sorted (Nothing, since this is an inplace sorting method)
  
  - Algorithm:
    1. Declare an integer variable 'n' and assign the value of the length of the array to it.
    2. Declare a boolean variable 'swapCheck', this variable will be used to check if swap happened in an iteration.
    2. Repeat until value of i is lesser than n-1:
      1. Declare an integer variable 'j' and assign its value as 0.
      2. Set the value of swapCheck as false.
      3. Repeat until the value of j is lesser than n-i-1: (
         1. If the element at index 'j' is greater than the element at index 'j+1', then:
            1. Swap the values of elements at indices j & j+1 using the utility function.
            2. Set the value of swapCheck as true.
            3. Increment 'j' by 1
      4. If the value of swapCheck is false, then
         1. Break the loop.
      5. Increment 'i' by 1

  - Best Case Time Complexity: O(n), means when the array is already sorted
  - Worst Case Time Complexity: O(n^2), when the array is in decreasing order
  - Stabiliity: stable (means, same elements will stay in the same order when swapped)
  - Inplace sort?: yes (means, no extra space (like creating a new array) is taken during this sort)

## Selection Sort:

  - Functionality: Selection Sort Selects the lowest/highest element from the array and swaps the position of that element with the element in the lowest/highest index respectively.
  
  - Input: Unsorted array
  - Output: Input array will be sorted (Nothing, since this is an inplace sorting method)

  - Algorithm:
    1. Declare an integer variable 'n' and assign the value of the length of the array to it.
    2. Declare an integer variable 'i' and initialize it as n-1.
    3. Repeat until 'i' is greater than zero:
      1.  Find the index of highest element using the utility function
      2.  Swap the value of the highest element with the element at current index 'i'
      3.  Decrement the value of 'i' by 1.
   
  - Best Case Time Complexity: O(n^2), 
  - Worst Case Time Complexity: O(n^2), even when the array is in increasing order, this algorithm will perform all comparisons it usually does.
  - Stabiliity: unstable (means, same elements will not stay in the same order when swapped)
  - Inplace sort?: yes (means, no extra space (like creating a new array) is taken during this sort)

## Insertion Sort:

  - Functionality: This is an algorithm which insert an element in the appropriate place in a sorted array. This is used in hybrid sorting algorithms, since it performs very less no. of swap when compared with bubble sort.

  - Input: Unsorted array
  - Output: Input array will be sorted (Nothing, since this is an inplace sorting method)

  - Algorithm:
    1. Declare an integer variable 'n' and assign the value of the length of the array to it.
    2. Declare an integer variable 'i' and initialize it as 0..
    3. Repeat until i is lesser than n-1:
       1. Declare an integer variable 'j' and initialize it as 'i+1'
       2. Repeat until j is greater than zero:
          1. If element at index 'j' is greater than element at index 'j-1', then:
            1. Break the inner loop.
          2. Swap the element at index 'j' with element at index j-1.
          3. Decrement the value of 'j' by 1. (This will keep swapping the current element to the left, until it reaches the appropriate position in the sorted array to it's left)
       3. Increment the value of 'i' by 1.
      
  - Best Case Time Complexity: O(n), means when the array is already sorted
  - Worst Case Time Complexity: O(n^2), when the array is in decreasing order
  - Stabiliity: stable (means, same elements will stay in the same order when swapped)
  - Inplace sort?: yes (means, no extra space (like creating a new array) is taken during this sort)

## Cyclic Sort:

- **Note:** When given number is of the range 1 to N, use cyclic sort.

- Functionality: This algorithm places each element at its correct index (value `x` should be at index `x-1`) by repeatedly swapping elements to their correct positions without traversing the array multiple times unnecessarily.

- Input: Unsorted array containing integers in the range `1` to `N`  
- Output: Input array will be sorted (Nothing, since this is an inplace sorting method)

- Algorithm:
  1. Declare an integer variable `temp` to be used for swapping.
  2. Declare an integer variable `n` and assign the value of the length of the array to it.
  3. Repeat until `i` is less than `n`:
     1. If the element at index `i` is **not** equal to `i+1`:
        1. Assign the value of the element at index `i` to `temp`.
        2. Assign the value `i+1` to the element at index `i`.
        3. Assign the value `temp` to the element at index `temp-1`.
     2. Otherwise, increment `i` by 1.
     
- Best Case Time Complexity: **O(n)**  
- Worst Case Time Complexity: **O(n)**  
- Stability: **Stable**  
- Inplace sort?: **Yes** (No new array is created, swapping is done in-place)

## Counting Sort:

- **Note:** This algorithm gets the count of each element in an array/object, then creates a new array and adds the element in the new array the same number of times it occurs in the old array.

- Functionality: Uses an auxiliary array (count array) where the index represents the element value and the stored value at that index represents how many times it appears in the original array. Uses cumulative counts to place elements in the correct positions.

- Input: Unsorted array  
- Output: New sorted array

- Algorithm:
  1. Declare an integer `n` as the length of the array.
  2. Declare an integer `maxElement` and set it to the first element of the array (used to determine the size of the count array).
  3. Repeat for each element in the array:
     1. If the current element is greater than `maxElement`, update `maxElement`.
     2. **Note:** This is to get the highest element to create an array in which the index represents the number, and the value at that index represents the count of the number of times it appears in the original array.
  4. Create an integer array `countArray` of size `maxElement+1`.
  5. For each element in the original array:
     1. Increment `countArray[element]` by 1.  
        **Note:** The value at an index is incremented for each occurrence in the original array.
  6. For each `i` from 1 to `maxElement`:
     1. Update `countArray[i] += countArray[i-1]`.  
        **Note:** This is to set the index of the elements in place.
  7. Create a new integer array `retArr` of size `n`.
  8. Traverse the original array from end to start (`i = n-1` to `0`):
     1. Decrement `countArray[arr[i]]` by 1 and use that index to place the element in `retArr`.  
        **Note:** We traverse in reverse because the count array stores the largest position of the element in it. The index of the count array represents the element, and the value in the count array represents its occurrence count. Adding elements from right to left preserves the order of duplicate elements (stability).
  9. Return `retArr`.

- Best Case Time Complexity: **O(n)**  
- Worst Case Time Complexity: **O(n)**  
- Stability: **Stable** (order of same elements is preserved)  
- Inplace sort?: **No** (New array is returned)

## Radix Sort:

- **Note:** Main logic of this algorithm: sort the array using counting sort for each digit, starting from the least significant digit. If there are mismatching number of digits, most significant digits of the smaller number are considered zero.

- Functionality: Performs multiple passes of counting sort, each time on a specific digit position (units, tens, hundreds, etc.).

- Input: Unsorted array of non-negative integers  
- Output: New sorted array

- Algorithm:
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
     6. Print the array for the current digit place: `"Final Array for i="+i+":"+Arrays.toString(retArr)`.
  5. Return `retArr`.

- Best Case Time Complexity: **O(n)**  
- Worst Case Time Complexity: **O(n)**  
- Stability: **Stable**  
- Inplace sort?: **No** (Intermediate array is created)


# Utility Functions:

## Swap:
  - Functionality: Swaps the values of two indices in an array
  - Input: Array, index 1, index 2
  - Output: Array after swap
  - Algorithm
    1. Create a temporary variable 'temp' and assign the value of element at index 1 in the array to it.
    2. Assign the value of element at index 2 to the element at index 1.
    3. Assign the value of 'temp' to the element at index 2.
   
## Max Element Index:

**Note:** Rewrite this to find the minimum element index, if the algorithm wants to work that way.
  - Functionality: To find the index of the highest element in the array.
  - Input: Unsorted Array
  - Output: Index of the highest element
  - Algorithm:
    1. Create an integer element 'n' and assign the length of the array to it.
    2. Create an integer element 'maxIndex' and initialize it's value as 0
    3. Create an integer element 'i' and initialize its value as 1.
    4. Repeat until 'i' is not lesser than n:
       1. If element at index 'i' is greater than element at index 'maxIndex', then:
          1. Set the value of 'maxIndex' as the value of i.
       2. Increment 'i' by 1
    5. Return the value of maxIndex.
