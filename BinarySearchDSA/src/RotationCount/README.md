# Rotation Count in a Rotated Sorted Array

We are given a rotated sorted array `arr` (rotation of a sorted array).  
The goal of this code is to find the **number of times the array has been rotated**.  

Rotation count = index of the **smallest element** in the array.  

For example:  
- `[0,1,2,3,4,5]` → rotation count = 0  
- `[4,5,0,1,2,3]` → rotation count = 2

## Algorithm

1. Initialize two pointers:  
   - `start = 0`, `end = arr.length - 1`

2. Run a loop while `start <= end`:  
   - Compute `mid = start + (end - start)/2`

3. Check pivot conditions:  
   - If `arr[mid] > arr[mid + 1]` → smallest element is at `mid + 1` → print `mid + 1` (rotation count).  
   - If `arr[mid] < arr[mid - 1]` → smallest element is at `mid` → print `mid`.  

4. Adjust search range:  
   - If `arr[start] < arr[mid]` → left half is sorted → move right (`start = mid + 1`).  
   - Else → move left (`end = mid - 1`).  

5. If no pivot is found, array is not rotated → print `0`.

## Example Walkthrough

### Example 1
**Input:**  
`arr = [2, 1, 0]`

- Start = 0, End = 2  
- Mid = 1 → `arr[1] = 1`  
- Condition: `arr[mid] < arr[mid - 1]` → 1 < 2 → rotation point = `mid = 1`.  
- Rotation count = 1  

**Output:**  
`1`

### Example 2
**Input:**  
`arr = [0, 1, 2]`  

- Array is already sorted, no rotation.  
- Loop completes without finding pivot.  
- Print `0`.  

**Output:**  
`0`

## Complexity Analysis

- **Time Complexity:** `O(log n)` (binary search approach)  
- **Space Complexity:** `O(1)` (only pointers used)  
