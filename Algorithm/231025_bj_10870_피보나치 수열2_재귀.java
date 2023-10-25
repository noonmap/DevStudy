import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		memo = new int[21];
		System.out.println(fibonacci(N));
	}
	static int[] memo;
	public static int fibonacci(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		if(memo[n] != 0) return memo[n];
		memo[n] = fibonacci(n-1) + fibonacci(n-2);;
		return memo[n];
	}
}
