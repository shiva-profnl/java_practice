# Insertion Sort:

  - **Functionality:** This is an algorithm which insert an element in the appropriate place in a sorted array. This is used in hybrid sorting algorithms, since it performs very less no. of swap when compared with bubble sort.

  - **Input:** Unsorted array
  - **Output:** Input array will be sorted (Nothing, since this is an inplace sorting method)

  - ## Algorithm:
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
      
  - **Best Case Time Complexity:** O(n), means when the array is already sorted
  - **Worst Case Time Complexity:** O(n^2), when the array is in decreasing order
  - **Stabiliity:** stable (means, same elements will stay in the same order when swapped)
  - **Inplace sort?:** yes (means, no extra space (like creating a new array) is taken during this sort)