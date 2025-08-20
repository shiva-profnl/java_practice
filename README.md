# Java Coding practice

## Sorting:
  - Bubble Sort: Completed
  - Selection Sort: Completed
  - Insertion Sort: Completed
  - Cyclic Sort: Completed
  - Count Sort: Completed
  - Radix Sort: Completed
  - Merge Sort: Revise
  - Quick Sort: Revise
  - Heap Sort: No idea
  
Cheat Sheet:
- Fibonacci Nth Term Formula:
  * The nth term of the Fibonacci sequence can be calculated using Binet's formula, which is an explicit closed-form expression. The formula is given by:

    $F_n = \frac{\varphi^n - (1 - \varphi)^n}{\sqrt{5}}, \quad \varphi = \frac{1 + \sqrt{5}}{2}$

- Akra-Bazzi Formula for finding time complexities of divide and conquer type recurrance relations:

  * $T(x) = \Theta\left( x^p \left( 1 + \int_{1}^{x} \frac{g(u)}{u^{p+1}} \, \mathrm{d}u \right) \right), \quad \text{where } p \text{ satisfies } \sum_{i=1}^{k} a_i b_i^p = 1$
 
- Newton-Raphson Method for Finding Roots:

  * The Newton-Raphson iteration formula is derived from the first-order Taylor expansion and is given by:

    $x_{n+1} = x_n - \frac{f(x_n)}{f'(x_n)}$

  * Starting with an initial guess $x_0$, the method converges quadratically (for well-behaved functions) to a root of $f(x) = 0$, provided $f'(x) \neq 0$ near the root.
 
  * To find $\sqrt{n}$ using Newton-Raphson, we solve $f(x) = x^2 - n = 0$ with $f'(x) = 2x$.
  
  * The iteration formula becomes:

    $x_{k+1} = \frac{x_k + \tfrac{n}{x_k}}{2}$

  * Starting from an initial guess $x_0$, the sequence converges to $\sqrt{n}$.
 
- Newton-Raphson Method for k-th Root:

  * To find the k-th root of a number $n$ (i.e., solve $x = \sqrt[k]{n}$), we set up the equation:
  
    $f(x) = x^k - n = 0$

  * Its derivative is:

    $f'(x) = kx^{k-1}$

  * Applying the Newton-Raphson formula:

    $x_{m+1} = x_m - \frac{f(x_m)}{f'(x_m)}$

    gives

    $x_{m+1} = x_m - \frac{x_m^k - n}{k x_m^{k-1}}$

  * Simplifying:

    $x_{m+1} = \frac{(k-1)x_m + \tfrac{n}{x_m^{k-1}}}{k}$

  * Starting with an initial guess $x_0$, the sequence $\{x_m\}$ converges to $\sqrt[k]{n}$, provided $x_0 > 0$.


    
​
