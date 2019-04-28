package DynamicProgramming;

public class Fibonacci {
	
	public static int fibo(int n) {
		if(n <= 1) return n;
		else return fibo(n-2) + fibo(n-1); 
	}
	
	public static void main(String[] args) {
		int input = 5;
		
		for (int i = 1; i <= input; i++)
			System.out.println(fibo(i));
	}
	
	/*
	 * Memory
	 * F(1)
	 * F(2)
	 * F(3)
	 * F(4)
	 * F(5)
	 * main()
	 */
}
