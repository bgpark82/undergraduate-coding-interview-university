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