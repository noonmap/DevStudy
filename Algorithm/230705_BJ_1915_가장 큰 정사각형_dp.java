import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, M;
	static int[][] dp; // 한 변씩 늘려가며 최대 정사각형 크기 저장
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new int[N][M];
		boolean isAllZero = true;
		for(int i=0; i<N; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				dp[i][j] = arr[j] == '1' ? 1 : 0;
				if(dp[i][j] == 1) isAllZero = false;
			}
		}
		
		if(isAllZero) {
			System.out.println(0);
			return;
		}
		int[] px = {-1, 0, -1};
		int[] py = {-1, -1, 0};
		int maxLen = 1;
		for(int n=1; n<N; n++) {
			for(int m=1; m<M; m++) {
				if(dp[n][m] == 0) continue; // 1일 때만 검사함
				int minlen = 1001;
				for(int p=0; p<3; p++) { // 현재 위치 주변 3개 검사 : 예) 모두 2이상 이면 현재 위치 기준 3x3이 정사각형인 것
					int y = n + py[p];
					int x = m + px[p];
					minlen = Math.min(dp[y][x], minlen);
				}
				dp[n][m] = minlen + 1; // 예) 전부 1이면 -> 2, 0이 있으면 -> 1
				maxLen = Math.max(maxLen, dp[n][m]); // 최대 변길이 갱신
				
			}
		}
			
		System.out.println(maxLen * maxLen);
	}
}
