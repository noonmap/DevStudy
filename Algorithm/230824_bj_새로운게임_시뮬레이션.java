import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static class HORSE{
		int p, n;
		HORSE(int p, int n){
			this.p = p;
			this.n = n;
		}
	}
	static class HORSE_SEQ{
		int x, y;
		HORSE_SEQ(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N, K;
	static int[][] board;
	static ArrayDeque<HORSE>[][] horse; // N,N
	static HORSE_SEQ[] horseSeq;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		horse = new ArrayDeque[N][N];
		horseSeq = new HORSE_SEQ[K];
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++)
				horse[i][j] = new ArrayDeque<>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int p = Integer.parseInt(st.nextToken())-1;
			horseSeq[i] = new HORSE_SEQ(x, y);
			horse[y][x].add(new HORSE(p, i));
		}
		
		boolean end = false;
		int turn = 0;
		while(turn <= 1000) {
			turn++;
			for(int k=0; k<K; k++) {
				// 말 순서대로
				int x = horseSeq[k].x;
				int y = horseSeq[k].y;
				
				// 말이 가장 밑에 있으면 진행, 아니면 skip
				HORSE h = horse[y][x].getFirst();
				int n = h.n;
				if(k != n) continue;
				
				// 진행방향으로 이동
				move(k, x, y, h.p, 0);
				
				x = horseSeq[k].x;
				y = horseSeq[k].y;
				
				if(horse[y][x].size() >= 4) {
					end = true;
					break;
				}
			}
			if(end) break;
		}
		if(turn > 1000) System.out.println(-1);
		else System.out.println(turn);
	}
	static int[] px = {1, -1, 0, 0};
	static int[] py = {0, 0, -1, 1};
	public static void move(int k, int x, int y, int p, int callCnt) {
		int nx = x + px[p];
		int ny = y + py[p];
		// 1. 경계선 바깥
		if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
			if(callCnt == 0) {
				// 방향 바꿔서, 바꾼 방향으로 move함
				p = (p&1)==1? p-1 : p+1;
				horse[y][x].getFirst().p = p; // 방향 바꿈
				move(k, x, y, p, 1);
			}
			return;
		}
		switch(board[ny][nx]) {
		// 2. 흰색
		case 0:{
				// 이전 위치 -> 다음 위치의 ArrayDeque에 얹
				// 현재 말의 위치 -> 다음 위치로 위치값 갱신
				ArrayDeque<HORSE> cur = horse[y][x];
				ArrayDeque<HORSE> next = horse[ny][nx];
				while(!cur.isEmpty()) {
					HORSE h = cur.removeFirst();
					next.add(h);
					horseSeq[h.n].x = nx;
					horseSeq[h.n].y = ny;					
				}
//				next.addAll(cur);
//				horse[y][x] = new ArrayDeque<>();
//				horseSeq[k].x = nx;
//				horseSeq[k].y = ny;
				break;
			}
		// 3. 빨간색
		case 1:{
				// 이전 위치의 원소 reverse,
				// 다음은 흰색과 같음
				ArrayDeque<HORSE> cur = horse[y][x];
				ArrayDeque<HORSE> next = horse[ny][nx];
				while(!cur.isEmpty()) {
					HORSE h = cur.removeLast();
					next.add(h);
					horseSeq[h.n].x = nx;
					horseSeq[h.n].y = ny;					
				}
//				horseSeq[k].x = nx;
//				horseSeq[k].y = ny;					
				break;
			}
		// 4. 파란색
		case 2:
			{
				if(callCnt == 0) {					
					// 방향 바꿔서, 바꾼 방향으로 move함
					p = (p&1)==1? p-1 : p+1;
					horse[y][x].getFirst().p = p; // 방향 바꿈
					move(k, x, y, p, 1);
				}
				break;
			}
		}
	}
}