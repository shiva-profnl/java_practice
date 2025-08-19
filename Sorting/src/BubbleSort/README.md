# Bubble Sort (Optimized)

- Also known as "Sinking Sort" or "Exchange Sort".

  - **Functionality**: Swaps the value of two adjacent indices if in element at the lower index is greater than the element at the higher index. If no swap happens in an iteration, then the algorithm understands that the array is sorted and ends.

  - **Input**: Unsorted array
  - **Output**: Input array will be sorted (Nothing, since this is an inplace sorting method)
  
  - ## Algorithm:
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

  - **Best Case Time Complexity:** O(n), means when the array is already sorted
  - **Worst Case Time Complexity:** O(n^2), when the array is in decreasing order
  - **Stabiliity:** stable (means, same elements will stay in the same order when swapped with different elements)
  - **Inplace sort?:** yes (means, no extra space (like creating a new array) is taken during this sort)