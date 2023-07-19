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
		
		// n�� lower_bound ����
		// dp[idx-1].sum + n => ������ (index > 0 �� ���)
		dp = new int[N+1];
		
		dp[0] = arr[0];
		int result = dp[0];
		for(int e=1; e<N; e++) {
			dp[e] = arr[e]; // ���� ��� arr[s]���� ������, ���߿� ���� �� Ŭ �� ����
			for(int s=0; s<e; s++) { // ó������ e-1���� �˻�
				if(arr[s] < arr[e]) {
					dp[e] = Math.max(dp[s] + arr[e], dp[e]);
					result = Math.max(result, dp[e]);
				}
			}
		}
		System.out.println(result);
		
	}
}
