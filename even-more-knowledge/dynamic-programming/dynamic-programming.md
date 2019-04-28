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

Memoization : table is filled on demain  
Tabulation : table is filled one by one from the beginning

## Recursion vs Memoization vs Tabulation

Time taken by Recursion method is much more than the two Dynamic Programming techniques - Memoization and Tabulation

## 2. Optimal Substructure

A given problems has Optimal Substructure Property if optimal solution of the given problem can be obtained by using optimal solutions of its subproblems

if a node `x` lies in the shortest path from a source node `u` to destination node `v` then the shortest path from `u` to `v` is combination of shortest path from `u` to `x` and shortest path from `x` to `v`.

```
Shortest path from u to v is combination of 1 and 2
u -> x -> v 

1. Shortest path u -> x
2. Shortest path x -> v
```

### Floyd Warshall Algorithm

```
package DynamicProgramming;

public class FloydWarshall {
	final static int INF = 99999, V = 4; 
	  
    void floydWarshall(int graph[][]) 
    { 
        int dist[][] = new int[V][V]; 
        int i, j, k; 
  
        /* Initialize the solution matrix same as input graph matrix. 
           Or we can say the initial values of shortest distances 
           are based on shortest paths considering no intermediate 
           vertex. */
        for (i = 0; i < V; i++) 
            for (j = 0; j < V; j++) 
                dist[i][j] = graph[i][j]; 
  
        /* Add all vertices one by one to the set of intermediate 
           vertices. 
          ---> Before start of an iteration, we have shortest 
               distances between all pairs of vertices such that 
               the shortest distances consider only the vertices in 
               set {0, 1, 2, .. k-1} as intermediate vertices. 
          ----> After the end of an iteration, vertex no. k is added 
                to the set of intermediate vertices and the set 
                becomes {0, 1, 2, .. k} */
        for (k = 0; k < V; k++) 
        { 
            // Pick all vertices as source one by one 
            for (i = 0; i < V; i++) 
            { 
                // Pick all vertices as destination for the 
                // above picked source 
                for (j = 0; j < V; j++) 
                { 
                    // If vertex k is on the shortest path from 
                    // i to j, then update the value of dist[i][j] 
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j]; 
                    		printSolution(dist);
                    }
                } 
            } 
        } 
  
        // Print the shortest distance matrix 
        printSolution(dist); 
    } 
  
    void printSolution(int dist[][]) 
    { 
        System.out.println("The following matrix shows the shortest "+ 
                         "distances between every pair of vertices"); 
        for (int i=0; i<V; ++i) 
        { 
            for (int j=0; j<V; ++j) 
            { 
                if (dist[i][j]==INF) 
                    System.out.print("INF "); 
                else
                    System.out.print(dist[i][j]+"   "); 
            } 
            System.out.println(); 
        } 
    } 
  
    // Driver program to test above function 
    public static void main (String[] args) 
    { 
        /* Let us create the following weighted graph 
           10 
        (0)------->(3) 
        |         /|\ 
      5 | 	       | 
        |          | 1 
        \|/        | 
        (1)------->(2) 
           3           */
        int graph[][] = { {0,   5,  INF, 10}, 
                          {INF, 0,   3, INF}, 
                          {INF, INF, 0,   1}, 
                          {INF, INF, INF, 0} 
                        }; 
        FloydWarshall a = new FloydWarshall(); 
  
        // Print the solution 
        a.floydWarshall(graph); 
    } 
}
```

[1](/img/1.png)

## Reference
[Overlapping Subproblems Property in Dynamic Programming | DP-1](https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/)
[Floyd Warshall Algorithm | DP-16](https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/)
[Principle of Optimality - Dynamic Programming](https://www.youtube.com/watch?v=_zE5z-KZGRw)
[Floyd–Warshall algorithm in 4 minutes](https://www.youtube.com/watch?v=4OQeCuLYj-4)
