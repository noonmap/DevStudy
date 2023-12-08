import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N][40_501];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] weights = new int[N];
		for(int i=0; i<N; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
		}
		
		
		dp[0][0] = 1;
		dp[0][weights[0]] = 1;
		for(int w=1; w<N; w++) {
			dp[w][0] = 1;
			int curw = weights[w];
			dp[w][curw] = 1;
			for(int i=1; i<40_000; i++) {
				// "현재 추 + 다른 추 == 구슬" 또는 "현재 추 == 구슬 + 다른 추" 인 경우
				dp[w][i] = Math.max(dp[w-1][i], dp[w-1][Math.abs(i-curw)]);
				// "구슬 + 현재 추 == 다른 추의 합" 인 경우
				dp[w][i] = Math.max(dp[w][i], dp[w-1][i+curw]);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int i=0; i<K; i++) {
			int m = Integer.parseInt(st.nextToken());
			if(dp[N-1][m] == 1) sb.append("Y ");
			else sb.append("N ");
		}
		System.out.println(sb.toString());
	}
}