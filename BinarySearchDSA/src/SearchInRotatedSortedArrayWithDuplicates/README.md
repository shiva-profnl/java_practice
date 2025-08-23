# Search in Rotated Sorted Array with Duplicates – Pivot Finding

We are given a rotated sorted array `arr` that **may contain duplicates**.  
The goal of the code is to **find the pivot index**, i.e., the index of the largest element in the array.  

The pivot is the point where the array rotation happens, which means:
- If `arr[pivot] > arr[pivot + 1]`, then `pivot` is the rotation point.  
- If no such point is found, the array is not rotated.

## Algorithm

1. **Initialize pointers**:
   - `start = 0`, `end = arr.length - 1`

2. **Iterate using Binary Search**:
   - Compute `mid = start + (end - start) / 2`.

3. **Check Pivot Conditions**:
   - If `arr[mid] > arr[mid+1]` → `mid` is the pivot.  
   - If `arr[mid] < arr[mid-1]` → `mid-1` is the pivot.

4. **Handle Duplicates**:
   - If `arr[start] == arr[mid] == arr[end]`, we cannot decide which side is sorted.  
     - Move `start++` and `end--` after checking edge cases.  

5. **Normal Binary Search Logic**:
   - If **left side is sorted** (`arr[start] < arr[mid]`) → Pivot must be on the right → `start = mid + 1`.  
   - Else → Pivot must be on the left → `end = mid - 1`.

6. **Return `-1`** if no pivot is found (i.e., array is not rotated).

## Example Walkthrough

### Example 1
**Input:**  
`arr = [2, 9, 2, 2, 2]`

- Start = 0, End = 4  
- Mid = 2 → `arr[mid] = 2`  
- Duplicates case: `arr[start] == arr[mid] == arr[end]` → shrink search space.  
- Eventually, the algorithm finds `pivot = 1` (value `9`).  

**Output:**  
`Pivot: 1`

## Complexity Analysis
- **Time Complexity:** Worst case `O(n)` (when many duplicates force us to shrink the search space one by one).  
- **Best/Average Case:** `O(log n)` (binary search efficiency).  
- **Space Complexity:** `O(1)` (only pointers used)
