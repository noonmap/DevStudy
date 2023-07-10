import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int T, W;
	static int[] plum;
	static int[][][] memo; // [W][Time][Tree] = [W 남은횟수][현재 시간][현재 위치] 일 때 최대 개수
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		// W=0일때 부터 W=W일 때까지 순서대로 구핢
		// P(W, Time, Tree) = max( P(W, T+1, anoT) + AnoPlum , P(W-1, T+1, T) + CurPlum )
		plum = new int[T];
		memo = new int[W+1][T+1][2];
		
		for(int i=0; i<T; i++) {
			plum[i] = Integer.parseInt(br.readLine())-1;
		}
		// memo 초기화
		for(int w=0; w<=W; w++) {
			for(int t=0; t<T; t++) {
				for(int r=0; r<2; r++) {
					memo[w][t][r] = -1;
				}
			}
		}
		// w=0 일 때
		// 현재 시간에 현재 위치에서 최대 개수 = 다음 시간에 현재 위치에서 최대개수 + 현재 시간에 딸 수 있는 개수
		for(int t=T-1; t>=0; t--) {
			memo[0][t][0] = memo[0][t+1][0] + getPlum(0, t);
			memo[0][t][1] = memo[0][t+1][1] + getPlum(1, t);
		}

		for(int w=1; w<=W; w++) {
			dp(w, 0, 0); // 1위치에서 시작
			
		}
		System.out.println(memo[W][0][0]);
	}
	// 자두 떨어지는 나무 == 현재 나무 위치 => get 1 / 다르면 get 0
	public static int getPlum(int curTree, int curTime) {
		if(curTree == plum[curTime]) return 1;
		return 0;
	}
	// W 이동 횟수 남았을 때, 현재 시간에 현재 위치에서 최대개수
	public static int dp(int w, int t, int curTree) {
		if(t == T) 
			return 0;
		if(memo[w][t][curTree] != -1) 
			return memo[w][t][curTree];
		
		int anoTree  = (curTree + 1)%2;
		return (memo[w][t][curTree] = Math.max(
				getPlum(curTree, t) + dp(w, t+1, curTree), // 현재 위치에서 이동 X
				getPlum(anoTree, t) + dp(w-1, t+1, anoTree) // 현재 위치에서 이동 O
				));
	}
	
}
