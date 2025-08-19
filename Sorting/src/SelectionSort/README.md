# Selection Sort:

  - **Functionality:** Selection Sort Selects the lowest/highest element from the array and swaps the position of that element with the element in the lowest/highest index respectively.
  
  - **Input:** Unsorted array
  - **Output:** Input array will be sorted (Nothing, since this is an inplace sorting method)

  - ## Algorithm:
    1. Declare an integer variable 'n' and assign the value of the length of the array to it.
    2. Declare an integer variable 'i' and initialize it as n-1.
    3. Repeat until 'i' is greater than zero:
      1.  Find the index of highest element using the utility function
      2.  Swap the value of the highest element with the element at current index 'i'
      3.  Break the inner loop of finding the greatest element and swapping after every swap.
      3.  Decrement the value of 'i' by 1.
   
  - **Best Case Time Complexity:** O(n^2), 
  - **Worst Case Time Complexity:** O(n^2), even when the array is in increasing order, this algorithm will perform all comparisons it usually does.
  - **Stabiliity:** unstable (means, same elements will not stay in the same order when swapped)
  - **Inplace sort?:** yes (means, no extra space (like creating a new array) is taken during this sort)