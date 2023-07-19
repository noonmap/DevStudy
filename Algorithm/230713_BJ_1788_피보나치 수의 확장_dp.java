import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		long[] dp = new long[2_000_002];
		int piv = 1_000_000;
		dp[piv] = 0;
		dp[piv+1] = 1;
		if(N < 0) {
			for(int i=-1; i>=N; i--) {
				dp[i+piv] = (dp[i+2+piv] - dp[i+1+piv])%1_000_000;
			}
		}
		else {
			for(int i=2; i<=N; i++) {
				dp[i+piv] = (dp[i-1+piv] + dp[i-2+piv])%1_000_000;
			}
		}
		if(dp[N+piv] > 0)
			System.out.println("1\n" + (dp[N+piv] % 1_000_000_000));
		else if(dp[N+piv] < 0)
			System.out.println("-1\n" + ((-dp[N+piv]) % 1_000_000_000));
		else
			System.out.println("0\n0");
	}
}
