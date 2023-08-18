import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N, M, K;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		bfs();
		if(answer == 987654321) System.out.println(-1);
		else System.out.println(answer);
	}
	
	static int answer = 987654321;
	static int[] px = {-1, 0, 1, 0};
	static int[] py = {0, -1, 0, 1};
	public static void bfs() {
		Queue<Integer> qx = new ArrayDeque<>();
		Queue<Integer> qy = new ArrayDeque<>();
		Queue<Integer> qk = new ArrayDeque<>();
		Queue<Integer> qd = new ArrayDeque<>(); // ¿Ãµø«— ∞≈∏Æ
		Queue<Integer> qday = new ArrayDeque<>(); // 1 : day, 0 : night
		int[][][] visit = new int[K+1][N][M];
		for(int i=0; i<K+1; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					visit[i][j][k] = 987654321;
				}
			}
		}
		visit[K][0][0] = 1;		
		qx.add(0);
		qy.add(0);
		qk.add(K);
		qd.add(1);
		qday.add(1);
		while(!qx.isEmpty()) {
			int cx = qx.remove();
			int cy = qy.remove();
			int ck = qk.remove();
			int cd = qd.remove();
			int cday = qday.remove();
//			System.out.println(String.format("cx: %d, cy = %d, dist: %d, day: %d", cx, cy, cd, cday));
			
			if(cx == M-1 && cy == N-1) {
				answer = Math.min(answer, cd);
				continue;
			}
			// 4πÊ
			for(int p=0; p<4; p++) {
				int nx = cx + px[p];
				int ny = cy + py[p];
				int nk = ck;
				int nd = cd + 1;
				int nday = (cday+1)%2; // ≥∑π„πŸ≤Ò
//				System.out.println(String.format("\tnx: %d, ny = %d, dist: %d, day: %d", nx, ny, nd, nday));
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				if(map[ny][nx] == '1') {
					if(nk == 0) continue;
					nk--; // ∫Æ ∂’
					if(cday == 0) { // ø¿¥√¿Ã π„¿Ã∏È ≥∑±Ó¡ˆ ¡¶¿⁄∏Æ ¿Ãµø«ÿæﬂ«‘
						nd ++; // ¡¶¿⁄∏Æ ∆˜«‘ ¿Ãµø
						nday = 0; // π„ -> ≥∑ -> π„
					}
				}
				if(visit[nk][ny][nx] <= nd) continue;
				qx.add(nx);
				qy.add(ny);
				qk.add(nk);
				qd.add(nd);
				qday.add(nday);
				visit[nk][ny][nx] = nd;
			}
		}
		
	}
} 