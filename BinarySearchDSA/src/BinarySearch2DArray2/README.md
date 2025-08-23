### Problem
You are given an `m x n` matrix where:
- Each row is sorted in ascending order from left to right.
- Each column is sorted in ascending order from top to bottom.

Write an algorithm to check if a given target exists in the matrix.

### Algorithm (O(m + n) Approach)

1. **Initialization**
   - Start from the **top-right corner**:
     \[
     row = 0, \quad col = n - 1
     \]

2. **Iterate Until Out of Bounds**
   - While \( row < m \) and \( col \geq 0 \):
     - If \( matrix[row][col] = target \) → return `true`
     - If \( matrix[row][col] > target \) → move **left**:
       \[
       col = col - 1
       \]
     - Else ( \( matrix[row][col] < target \) ) → move **down**:
       \[
       row = row + 1
       \]

3. **If Loop Ends**
   - Return `false` (target not found).

### Example
- **Input**  
  \[
  matrix = 
  \begin{bmatrix}
  1 & 4 & 7 & 11 & 15 \\
  2 & 5 & 8 & 12 & 19 \\
  3 & 6 & 9 & 16 & 22 \\
  10 & 13 & 14 & 17 & 24 \\
  18 & 21 & 23 & 26 & 30
  \end{bmatrix}, \quad target = 18
  \]

- **Process**
  - Start at \( (0,4) = 15 \), since \( 18 > 15 \), move **down**.
  - At \( (1,4) = 19 \), since \( 18 < 19 \), move **left**.
  - At \( (1,3) = 12 \), since \( 18 > 12 \), move **down**.
  - At \( (2,3) = 16 \), since \( 18 > 16 \), move **down**.
  - At \( (3,3) = 17 \), since \( 18 > 17 \), move **down**.
  - At \( (4,3) = 26 \), since \( 18 < 26 \), move **left**.
  - At \( (4,2) = 23 \), since \( 18 < 23 \), move **left**.
  - At \( (4,1) = 21 \), since \( 18 < 21 \), move **left**.
  - At \( (4,0) = 18 \), found target ✅.

- **Output**  
  `true`
