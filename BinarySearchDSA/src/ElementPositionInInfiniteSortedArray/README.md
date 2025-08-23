# Search Element in Infinite Sorted Array

## Problem
You are given an **infinite sorted array** (or conceptually infinite — we don’t know the end).  
The task is to find the **index of a target element** in this array.  

If the element does not exist, return `-1`.

## Key Idea
- Since the array is "infinite," we cannot use the normal binary search directly (because we don’t know the `end` of the array).  
- Instead, we first **find a search window** `[start, end]` that is guaranteed to contain the target.  
- Then we run a standard **binary search** within that window.

## Algorithm

1. **Initialize window:**  
   - `start = 0`, `end = 1`

2. **Expand window until target is within range:**  
   - While `arr[end] < target`:  
     - Move `start = end + 1`  
     - Double the window size:  
       \[
       end = newStart + (end - start) \times 2 + 1
       \]  
     - This ensures exponential growth of the window, so we find the correct range in `O(log p)` time (where `p` is the position of target).

3. **Binary Search in the window:**  
   - While `start <= end`:  
     - Compute `mid = start + (end - start) / 2`  
     - If `arr[mid] == target`, return `mid`  
     - If `arr[mid] > target`, search left (`end = mid - 1`)  
     - Else, search right (`start = mid + 1`)  

4. **If not found, return `-1`.**

## Examples

- **Example 1**  
    `arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}`
    `target = 10`
    - Window expands until it includes `10`  
    - Binary search finds `10` at index **4**  
    - **Output:** `4`

- **Example 2**  
    `arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}`
    `target = 90`
    - Window expands to include `90`  
    - Binary search finds `90` at index **5**  
    - **Output:** `5`

- **Example 3**  
    `arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170}`
    `target = -6`
    - Since `-6` is smaller than the smallest element, window expansion stops immediately  
    - Binary search returns `-1` (not found)  
    - **Output:** `-1`

## Complexity
- **Window Expansion:** `O(log p)` where `p` is the index of the target.  
- **Binary Search:** `O(log p)`  
- **Total:** `O(log p)`  
- **Space Complexity:** `O(1)`