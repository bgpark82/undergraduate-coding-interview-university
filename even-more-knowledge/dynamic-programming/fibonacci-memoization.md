# Fibonacci Memoization

```
package DynamicProgramming;

import java.nio.channels.ShutdownChannelGroupException;
import java.util.ArrayList;
import java.util.List;

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

# Reference
[Overlapping Subproblems Property in Dynamic Programming | DP-1](https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/)
[Dynamic Programming Set 1| Overlapping Subproblem properties](https://youtu.be/mmjDZGSr7EA)