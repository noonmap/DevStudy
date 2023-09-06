import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int T;
	static int K;
	static int[] arr;
	static int[][] memoi_cost; // 누적 최소 비용
	static int[][] memoi_sum; // 합쳐진 페이지
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			K = Integer.parseInt(br.readLine());
			memoi_cost = new int[500][500];
			memoi_sum = new int[500][500];
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[K];
			for(int i=0; i<K; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				memoi_sum[i][i] = arr[i];
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
			memoi_sum[si][ei] = arr[si] + arr[ei];
			memoi_cost[si][ei] = arr[si] + arr[ei];
			return memoi_cost[si][ei];
		}
		int min = 1_987_654_321;
		for(int m=si; m<ei; m++) {
			int a = dp(si, m);
			int b = dp(m+1, ei);
			min = Math.min(min, a + b + memoi_sum[si][m] + memoi_sum[m+1][ei]);
		}
		memoi_cost[si][ei] = min;
		memoi_sum[si][ei] = arr[si] + memoi_sum[si+1][ei];
		return min;
	}
}