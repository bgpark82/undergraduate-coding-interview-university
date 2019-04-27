# Fibonacci-tabulation

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
## Reference
[Overlapping Subproblems Property in Dynamic Programming | DP-1](https://www.geeksforgeeks.org/overlapping-subproblems-property-in-dynamic-programming-dp-1/)  
[Dynamic Programming Set 1| Overlapping Subproblem properties](https://youtu.be/mmjDZGSr7EA)