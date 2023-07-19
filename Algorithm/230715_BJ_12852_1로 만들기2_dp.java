import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[1_000_001][2]; // [][0] : 연산 횟수, [][1] : 직전 연산 종류(0:-1, 1:/2, 2:/3)
		dp[2][0] = dp[3][0] = 1;
		dp[2][1] = 1;
		dp[3][1] = 2;
		for(int i=4; i<=N; i++) {
			dp[i][0] = dp[i-1][0]+1;
			if(i%2 == 0 && dp[i/2][0]+1 < dp[i][0]) {
				dp[i][0] = dp[i/2][0] + 1;
				dp[i][1] = 1;
			}
			if(i%3 == 0 && dp[i/3][0]+1 < dp[i][0]) {
				dp[i][0] = dp[i/3][0] + 1;
				dp[i][1] = 2;
			}
		}
		System.out.println(dp[N][0]);
		while(N >= 1) {
			System.out.print(N + " ");
			if(dp[N][1] == 0) N--;
			else if(dp[N][1] == 1) N /= 2;
			else N /= 3;
		}
		
	}
}
  