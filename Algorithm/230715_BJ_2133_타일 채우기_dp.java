import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N;
	static int[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		if( (N&1) == 1) {
			System.out.println(0);
			return;
		}
		// dp[n] = 특이케(2) + dp[n-2]*dp[2](왼쪽에 있는 특케 모두 포함) + sum(2~N-4)(2*dp[n-x])
		// dp[n] = 2 + dp[n-2]*3 + (2*dp[n-(n-2)] + 2*dp[n-(n-4)] + ... + 2*dp[n-4])
		int[] dp = new int[31];
		dp[2] = 3;
		for(int i=4; i<=N; i+=2) {
			dp[i] = 2 + dp[i-2]*3;
			for(int n=2; n<=i-4; n+=2) {
				dp[i] += 2 * dp[n];
			}
		}
		System.out.println(dp[N]);
	}
}
  