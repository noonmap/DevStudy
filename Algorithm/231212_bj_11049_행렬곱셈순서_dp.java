import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] mat = new int[N][2]; // {r, c}
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			mat[i][0] = Integer.parseInt(st.nextToken());
			mat[i][1] = Integer.parseInt(st.nextToken());
		}
		int[][] dp = new int[N][N];
		
		for(int e=0; e<N; e++) {
			for(int s=e-1; s>=0; s--) {
				int min = -1 + (1<<31);
				for(int m=s; m<e; m++) {
					min = Math.min(min, dp[s][m] + dp[m+1][e] + mat[s][0]*mat[m][1]*mat[e][1]);
				}
				dp[s][e] = min;
			}
		}
//		for(int i=0; i<N; i++) {
//			for(int j=0; j<N; j++) {
//				System.out.print(String.format("%3d ", dp[i][j]));
//			}
//			System.out.println();
//		}
		System.out.println(dp[0][N-1]);
	}
}