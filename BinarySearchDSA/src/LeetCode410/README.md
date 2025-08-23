# LeetCode 410: Split Array Largest Sum

## Problem
You are given an integer array `nums` and an integer `k`.  
Split `nums` into `k` non-empty subarrays such that the **largest sum among these subarrays is minimized**.  
Return this minimized largest sum.

## Approach

1. The answer lies between:
   - `min = max(nums)` → because the largest single element cannot be split.
   - `max = sum(nums)` → if we put all elements in one subarray.

2. Perform **binary search** between `min` and `max`:
   - For each midpoint `mid`, check how many subarrays are needed if the largest allowed subarray sum is `mid`.
   - If the number of subarrays `<= k`, move left (`max = mid`).
   - Else, move right (`min = mid + 1`).

3. When binary search finishes, `min == max` gives the minimized largest sum.

## Example

**Input:**  
`nums = [7,2,5,10,8], k = 2`  

**Process:**  
- min = 10 (largest element), max = 32 (sum of array)  
- Binary search finds minimized largest sum = 18  

Split: `[7,2,5]` and `[10,8]` → max sum = 18  

**Output:**

## Complexity

- **Time Complexity:** `O(n log(sum(nums)))`  
- **Space Complexity:** `O(1)`

## Sample Run

**Input:**  
    `nums = [7,2,5,10,8], k = 2`

**Output:**  
    `18`