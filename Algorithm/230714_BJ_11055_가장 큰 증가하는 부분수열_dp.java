import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp; // [idx] = max sum
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// n의 lower_bound 구함
		// dp[idx-1].sum + n => 누적합 (index > 0 인 경우)
		dp = new int[N+1];
		
		dp[0] = arr[0];
		int result = dp[0];
		for(int e=1; e<N; e++) {
			dp[e] = arr[e]; // 앞이 모두 arr[s]보다 작지만, 나중에 합이 더 클 수 있음
			for(int s=0; s<e; s++) { // 처음부터 e-1까지 검사
				if(arr[s] < arr[e]) {
					dp[e] = Math.max(dp[s] + arr[e], dp[e]);
					result = Math.max(result, dp[e]);
				}
			}
		}
		System.out.println(result);
		
	}
}
