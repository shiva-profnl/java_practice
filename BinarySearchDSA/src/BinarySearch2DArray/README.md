**Note! Refer problem:** https://leetcode.com/problems/search-a-2d-matrix

### Problem
Given a 2D matrix where each row and column are sorted in non-decreasing order, search for a target element and return its position.  
If the element is not found, return "Not found".

---

### Algorithm (Formula-based)

1. **Initialize Pointers**
   - Rows:  
     \[
     m_{start} = 0, \quad m_{end} = rows - 1
     \]  
   - Columns:  
     \[
     n_{start} = 0, \quad n_{end} = cols - 1
     \]

2. **Step 1: Find Candidate Row (Binary Search on First Column)**
   - While \( m_{start} \leq m_{end} \):  
     \[
     m_{mid} = m_{start} + \frac{(m_{end} - m_{start})}{2}
     \]
     - If \( arr[m_{mid}][0] = target \) → return \([m_{mid}, 0]\)  
     - If \( arr[m_{mid}][0] < target \) →  
       \[
       m_{start} = m_{mid} + 1
       \]
     - Else →  
       \[
       m_{end} = m_{mid} - 1
       \]

3. **Step 2: Search Within Candidate Row**
   - Row is now fixed at \( m_{end} \).  
   - While \( n_{start} \leq n_{end} \):  
     \[
     n_{mid} = n_{start} + \frac{(n_{end} - n_{start})}{2}
     \]
     - If \( arr[m_{end}][n_{mid}] = target \) → return \([m_{end}, n_{mid}]\)  
     - If \( arr[m_{end}][n_{mid}] < target \) →  
       \[
       n_{start} = n_{mid} + 1
       \]
     - Else →  
       \[
       n_{end} = n_{mid} - 1
       \]

4. **Step 3: If Not Found**
   - Return `"Not found"`.

---

### Example
- **Input**  
  \[
  arr = 
  \begin{bmatrix}
  1 & 2 & 3 & 4 \\
  5 & 6 & 7 & 8 \\
  9 & 10 & 11 & 12 \\
  13 & 14 & 15 & 16
  \end{bmatrix}, \quad target = 13.9
  \]

- **Process**  
  - Row binary search → candidate row = last row.  
  - Column binary search in `[13, 14, 15, 16]` → target not found.

- **Output**  
  `"Not found"`
