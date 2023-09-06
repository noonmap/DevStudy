import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int T;
	static int K;
	static int[] arr;
	static int[][] memoi_cost; // 최소 비용
	static int[] accum_sum; // 페이지 누적 합
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		memoi_cost = new int[500][500];
		accum_sum = new int[501];
		while(T-- > 0) {
			K = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<K; i++) Arrays.fill(memoi_cost[i], 0);
			
			arr = new int[K];
			for(int i=0; i<K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				accum_sum[i+1] = accum_sum[i] + arr[i];
			}
			
			int m = dp(0, K-1); // start, end / ret : min cost
			System.out.println(m);
		}
	}
	public static int dp(int si, int ei) {
		if(memoi_cost[si][ei] > 0) return memoi_cost[si][ei];
		if(si == ei) {
			return 0;
		}
		if(si+1 == ei){
			memoi_cost[si][ei] = arr[si] + arr[ei];
			return memoi_cost[si][ei];
		}
		int min = 1_987_654_321;
		int sum = accum_sum[ei+1] - accum_sum[si];
		for(int m=si; m<ei; m++) {
			int a = dp(si, m);
			int b = dp(m+1, ei);
			min = Math.min(min, a + b + sum);
		}
		memoi_cost[si][ei] = min;
		return min;
	}
}