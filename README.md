# Binary Search Algorithm

Binary Search is an efficient algorithm to find the position of a target element in a **sorted array**.  
It works by repeatedly dividing the search interval in half.

---

## Formula

Given:
- A sorted array `nums` of length `n`
- A target value `x`

We maintain two pointers:
- `low = 0`
- `high = n - 1`

At each step, compute the middle index:

\[
mid = \left\lfloor \frac{low + high}{2} \right\rfloor
\]

- If `nums[mid] == x` → target found.  
- If `nums[mid] < x` → search the right half:  
  \[
  low = mid + 1
  \]
- If `nums[mid] > x` → search the left half:  
  \[
  high = mid - 1
  \]

The search continues until:
\[
low > high
\]

If this condition is reached, the target is **not present** in the array.

---

## Time Complexity
- Best case: `O(1)` (if middle element is the target)  
- Worst case: `O(\log n)`  

## Space Complexity
- `O(1)` (iterative version)
