import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, M;
	static char[][] map;
	static int cctvNum;
	static int[][] cctvPos;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		cctvPos = new int[8][2];
		int cnt=0; // 사각지대가 아닌 곳 카운트
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] != '0') cnt++; // cctv, 벽 cnt
				if('1' <= map[i][j] && map[i][j] <= '5') {
					cctvPos[cctvNum][0] = i;
					cctvPos[cctvNum][1] = j;
					cctvNum++;
				}
			}
		}
		
		// 1번 : 4방, 2:2방, 3:4방, 4:4방, 5:1방
		
		// 3. 모든 cctv에 대해 감시 위치 기록 
			// 1. cctv 위치 찾기;
			// 2. cctv 돌려가면서 감시 위치 찾기 (tmp에 기록)
		// 4. 사각 지대 카운트
		
		// 재귀로 모든 방향에 대해 사각지대 카운트		
		draw(0, map, cnt); // cctvIdx
		System.out.println(N*M - watchMaxCnt);
	}
	static int[] px = {-1, 0, 1, 0};
	static int[] py = {0, -1, 0, 1};
	static int watchMaxCnt = 0;
	
	public static void draw(int cctvIdx, char[][] tmp, int cnt) {
		if(cctvIdx == cctvNum) {
			watchMaxCnt = Math.max(cnt, watchMaxCnt);
			return;
		}
		
		int y = cctvPos[cctvIdx][0];
		int x = cctvPos[cctvIdx][1];
		int type = map[y][x];
		
		if(type == '2') { // 2방향
			for(int p=0; p<2; p++) {
				int cnt1=0;
				char[][] tmp1 = clonemap(tmp);
				cnt1 += move(p, x, y, tmp1);
				cnt1 += move((p+2)%4, x, y, tmp1);
				draw(cctvIdx+1, tmp1, cnt1 + cnt);
			}
		} else if(type == '5') { // 1방향
			int cnt2 = 0;
			char[][] tmp2 = clonemap(tmp);
			for(int p=0; p<4; p++) {
				cnt2 += move(p, x, y, tmp2);
			}
			draw(cctvIdx+1, tmp2, cnt2 + cnt);
		} else if(type == '1'){ // 4방향
			for(int p=0; p<4; p++) {
				int cnt1=0;
				char[][] tmp1 = clonemap(tmp);
				cnt1 += move(p, x, y, tmp1);
				draw(cctvIdx+1, tmp1, cnt1 + cnt);
			}
		} else if(type == '3') {
			for(int p=0; p<4; p++) {
				int cnt1=0;
				char[][] tmp1 = clonemap(tmp);
				cnt1 += move(p, x, y, tmp1);
				cnt1 += move((p+1)%4, x, y, tmp1);
				draw(cctvIdx+1, tmp1, cnt1 + cnt);				
			}
		} else if(type == '4') {
			for(int p=0; p<4; p++) {
				int cnt1=0;
				char[][] tmp1 = clonemap(tmp);
				cnt1 += move(p, x, y, tmp1);
				cnt1 += move((p+1)%4, x, y, tmp1);
				cnt1 += move((p+2)%4, x, y, tmp1);
				draw(cctvIdx+1, tmp1, cnt1 + cnt);				
			}			
		}
	}
	public static char[][] clonemap(char[][] origin){
		char[][] tmp = new char[N][M];
		for(int i=0; i<N; i++) tmp[i] = origin[i].clone();
		return tmp;
	}
	public static int move(int vec, int x, int y, char[][] tmp) {
		int cnt=0;
		while(true) {
			x = x + px[vec];
			y = y + py[vec];
			if(x < 0 || x >= M || y < 0 || y >= N) break;
			if(tmp[y][x] == '6') break; // 벽
			if(tmp[y][x] != '0') continue; // cctv, '#' 통과 가능
			tmp[y][x] = '#';
			cnt++;
		}
		return cnt;
	}
	
}
