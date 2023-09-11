import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	/*
	 * default min : |N-100|
	 * 최대한 가까운 수 : 
	 * 만들 수 있는 모든 수??
	 * => ??? 자리일 때, ??자리 ~ ????자리 까지 만들어서 검사
	 * => 총 6자리니까, 5자리(가장 큰 수) ~ 7자리 (가장 작은수)
	 * 1 + 10^6 + 1
	 */
	static int N, M;
	static int len;
	static boolean[] pos;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		M = Integer.parseInt(br.readLine().trim());
		pos = new boolean[10];
		Arrays.fill(pos, true);
		if(M > 0) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				pos[Integer.parseInt(st.nextToken())] = false; 
			}
		}
		
		int tmpN = N;
		while(tmpN > 0) {
			len++;
			tmpN /= 10;
		}
		len = Math.max(1, len);
	
		int minCnt = Math.abs(N-100);
		if(M < 10) {			
			// len-1자리 수 : 가장 큰 수
			int maxnum = -1;
			for(int i=9; i>=1; i--) {
				if(pos[i]) {
					maxnum = i;
					break;
				}
			}
			if(maxnum != -1 && len > 1) {				
				int smallch = 0;
				int ten = 1;
				for(int i=0; i<len-1; i++) {
					smallch += ten * maxnum;
					ten*=10;
				}
				minCnt = Math.min(len-1 + (N-smallch), minCnt);
			}
			// len+1자리 수 : 가장 작은 수
			int minnum = 900;
			for(int i=1; i<=9; i++) {
				if(pos[i]) {
					minnum = i;
					break;
				}
			}
			if(minnum != 900) {				
				int biggerch = 0;
				int ten = 1;
				if(pos[0]) {
					for(int i=0; i<len; i++) ten*=10;
					biggerch = minnum*ten;
				} else {
					for(int i=0; i<len+1; i++) {
						biggerch += minnum * ten;
						ten *= 10;
					}
				}
				minCnt = Math.min(len+1 + biggerch - N, minCnt);
			}
			// len자리 수
			minCnt = Math.min(minCnt, dfs(0, len, 0));
		}
		
		
		System.out.println(minCnt);
	}
	public static int dfs(int cnt, int len, int curnum) {
		if(cnt == len) {
			int tmp = curnum;
			int reallen = 0;
			while(tmp > 0) {
				reallen++;
				tmp/=10;
			}
			return Math.max(1, reallen) + Math.abs(N-curnum);
		}
		int min = 987654321;
		for(int i=0; i<10; i++) {
			if(!pos[i]) continue;
			min = Math.min(min, dfs(cnt+1, len, curnum*10 + i));
		}
		return min;
	}
}
