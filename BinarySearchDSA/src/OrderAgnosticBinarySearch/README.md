# Order Agnostic Binary Search

## Problem
We need to search for a target element inside a sorted array.  
The twist is that the array may be sorted in **ascending** or **descending** order.  
The algorithm must work for both.

## Algorithm (Logic)

1. Initialize:
   - `start = 0`
   - `end = arr.length - 1`

2. Determine the order:
   - If `arr[start] <= arr[end]`, then array is **ascending**.
   - Else, array is **descending**.

3. Run Binary Search:
   - While `start <= end`:
     - `mid = start + (end - start) / 2`
     - If `arr[mid] == target`, return `mid`.

   - If **ascending**:
     - If `target < arr[mid]`, move left → `end = mid - 1`
     - Else move right → `start = mid + 1`

   - If **descending**:
     - If `target > arr[mid]`, move left → `end = mid - 1`
     - Else move right → `start = mid + 1`

4. If not found, return `-1`.

## Time Complexity
- **O(log n)** because it is binary search.
- Works for both ascending and descending arrays.
