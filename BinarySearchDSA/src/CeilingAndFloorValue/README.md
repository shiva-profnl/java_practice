# Ceiling and Floor Value in a Sorted Array

Given a **sorted array** `arr` of integers and a `target` value, the goal is to find:

- **Ceiling:** The smallest element in `arr` that is **greater than or equal to** `target`.  
- **Floor:** The largest element in `arr` that is **less than or equal to** `target`.

If such an element does not exist, return `-1`.

## Algorithm

We use a modified **Binary Search** approach for both Ceiling and Floor:

### Ceiling Algorithm
1. Initialize `start = 0`, `end = arr.length - 1`.  
2. If `arr[end] < target`, return `-1` (no ceiling exists).  
3. While `start <= end`:  
   - Compute mid:  
     \[
     mid = start + \frac{end - start}{2}
     \]  
   - If `arr[mid] == target`, return `mid`.  
   - If `arr[mid] > target`, move left: `end = mid - 1`.  
   - If `arr[mid] < target`, move right: `start = mid + 1`.  
4. When the loop ends, `start` will point to the **ceiling index**.  
   Return `start`.

### Floor Algorithm
1. Initialize `start = 0`, `end = arr.length - 1`.  
2. If `arr[start] > target`, return `-1` (no floor exists).  
3. While `start <= end`:  
   - Compute mid:  
     \[
     mid = start + \frac{end - start}{2}
     \]  
   - If `arr[mid] == target`, return `mid`.  
   - If `arr[mid] > target`, move left: `end = mid - 1`.  
   - If `arr[mid] < target`, move right: `start = mid + 1`.  
4. When the loop ends, `end` will point to the **floor index**.  
   Return `end`.

## Example Execution

For:
```
    arr = {-18, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89}
    target = -90
```


- **Ceiling:** Function will return `0`, so, `arr[0] = -18`.  
- **Floor:** No element is `<= -90`, so output is `-1`.


## Time Complexity
- Each of Ceiling and Floor uses **Binary Search**.  
- **Time Complexity:** `O(log n)`  
- **Space Complexity:** `O(1)`