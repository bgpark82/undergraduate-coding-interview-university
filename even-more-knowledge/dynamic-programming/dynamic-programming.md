# Dynamic Programming

> Dynamic Programing is an algorithm paradigm that solves a given complex problem by breaking it into subproblems and stores the results of sub problems to avoid computing the same result again

1. break the problem into subproblems
2. store the result of subproblems

> Following are the two main properties of a problem that suggests that the given problem can be solved using Dynamic programming

1. Overlapping Subproblems
2. Optimal Subproblems

## 1. Overlapping Subproblems

Dynamic Programming is mainly used when solutions of same subproblems are needed over again. computed solutions to subproblems are stored in a table so that these don't have to be recomputed. **So dynamic programming is not useful when there are no common/overlapping subproblems because there is no point storing the solutions if they are not needed again**
   
if we take an example of following recursive program for Fibonacci Numbers, there are many subproblems which are computed over and over again
```
/* simple recursive program for Fibonacci numbers */
int fib(int n) 
{ 
   if ( n <= 1 ) 
      return n; 
   return fib(n-1) + fib(n-2); 
}
```

Recursion tree for execution of fib(5)

```  
                         fib(5)
                     /             \
               fib(4)                fib(3)
             /      \                /     \
         fib(3)      fib(2)         fib(2)    fib(1)
        /     \        /    \       /    \
  fib(2)   fib(1)  fib(1) fib(0) fib(1) fib(0)
  /    \
fib(1) fib(0)
```

**fib(0) : 3 times**  
**fib(1) : 5 times**  
**fib(2) : 3 times**  
**fib(3) : 2 times**  
fib(4) : 1 time   
fib(5) : 1 time   

We can see that the function fib(0) to fib(3) is being called over 2 times. if we would have stored those values for functions, then instead of computing it again and again, we could have reused the stored value to save resources. There are following two different way to store values 

1. Memoization (Top Down)
2. Tabulation (Bottom Up)

### 1-2 Memoization

The memoized program for a problem is similar to the recursive version with storing return values into array then call the same stored value in array while computing.

```
public class FactorialMemoization {

	static int[] f;
	
	private static int fib(int n) {
		if(n == 1 || n == 2) return 1;
		else if(f[n] > -1) return f[n];
		else {
			f[n] = fib(n-2) + fib(n-1);
			show();
			return f[n];
		}
	}
	
	private static void show() {
		for (int i = 0; i < f.length; i++) {
			System.out.print(f[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		f = new int[10];
		for (int i = 0; i < f.length; i++) {
			f[i] =-1;
		}
		System.out.println(fib(8));
	}
}
```

Output : `21`

### 1-2 Tabulation 

The tabulated program for a given problem builds a table in bottom up fashion and returns the last entry from table 

```
package DynamicProgramming;

public class FactorialTabulation {
	
	private static int[] f;
	
	public static void main(String[] args) {
		f = new int[10];
		show();
		System.out.println(fib(6));
	}
	
	private static int fib(int n) {
		f[1] = f[2] = 1;
		show();
		for (int i = 3; i <= n; i++) {
			f[i] = f[i-1] + f[i-2];
			show();
		}
		return f[n];
	}
	private static void show() {
		for (int i = 0; i < f.length; i++) {
			System.out.print(f[i] + " ");
		}
		System.out.println();
	}
}
```

Output : `8`

## Memoization vs Tabulation

Memoization | Tabulation
---
table is filled on demain | table is filled one by one from the beginning
---

## Recursion vs Memoization vs Tabulation

Time taken by Recursion method is much more than the two Dynamic Programming techniques - Memoization and Tabulation


## Reference
[Overlapping Subproblems Property in Dynamic Programming | DP-1](https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/)  
