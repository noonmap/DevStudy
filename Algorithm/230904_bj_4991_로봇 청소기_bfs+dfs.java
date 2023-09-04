import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int W, H;
	static int[][] map;
	static List<int[]> dirty;
	static List<int[]>[] adjList; // {거리, 목적 노드}
	static int robotNum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 while(true) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 W = Integer.parseInt(st.nextToken());
			 H = Integer.parseInt(st.nextToken());
			 if(W == 0 && H == 0) break;
			 
			 map = new int[H][W];
			 dirty = new ArrayList<>();
			 int dirtyCnt = 1;
			 for(int i=0; i<H; i++) {
				 char[] ch = br.readLine().toCharArray();
				 // 깨끗 : 0
				 // 로봇, 더러움 : 1 ~ 11
				 // 가구 : -1
				 for(int j=0; j<W; j++) {
					 if(ch[j] == '.') map[i][j] = 0;
					 else if(ch[j] == '*' || ch[j] == 'o') {
						 map[i][j] = dirtyCnt++;
						 dirty.add(new int[] {i, j});
					 }
					 else if(ch[j] == 'x') map[i][j] = -1;
					 if(ch[j] == 'o') robotNum = map[i][j];
				 }
			 }
			 
			 adjList = new ArrayList[dirty.size() + 1];
			 for(int i=1; i<dirty.size()+1; i++) adjList[i] = new ArrayList<>();
			 
			 // 로봇, 더러움 위치 기준 -> 다른 위치로의 최솟값 구하기 -> 인접리스트에 넣기
			 for(int[] pos : dirty) {
				 bfs(pos);
				 map[pos[0]][pos[1]] = 0;
			 }
			 int minLen = dfs(robotNum, 1<<robotNum, 0, 1);
			 if(minLen == 100_000_000) System.out.println(-1);
			 else System.out.println(minLen);
		 }
	}
	public static int dfs(int cur, int visit, int lenSum, int visitCnt) {		
		if(visitCnt == adjList.length-1) {
			return lenSum;
		}
		int min = 100_000_000;
		for(int[] adj : adjList[cur]) {
			if( (visit & (1 << adj[1])) > 0) continue;
			min = Math.min(min, dfs(adj[1], (visit | (1<<adj[1])), lenSum + adj[0], visitCnt+1));
		}
		return min;
	}
	
	static int[] px = {-1, 0, 1, 0};
	static int[] py = {0, -1, 0, 1};
	public static void bfs(int[] start) {
		 // 모든 방문할 수 있는 곳 방문, 최솟값 
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visit = new int[H][W];
		
		int startNum = map[start[0]][start[1]];
		
		q.add(start);
		visit[start[0]][start[1]] = 1;
		int len = -1;
		while(!q.isEmpty()) {
			int size = q.size();
			len++;
			while(size-- > 0) {				
				int[] c = q.remove();
				int val = map[c[0]][c[1]];
				if(val > 0 && val != startNum) {
					adjList[startNum].add(new int[] {len, val});
					adjList[val].add(new int[] {len, startNum});
				}
				for(int p=0; p<4; p++) {
					int ny = c[0] + py[p];
					int nx = c[1] + px[p];
					if(nx < 0 || nx >= W || ny < 0 || ny >= H) continue;
					if(map[ny][nx] < 0) continue;
					if(visit[ny][nx] == 1) continue;
					visit[ny][nx] = 1;
					q.add(new int[] {ny, nx});
				}
			}			
		}
	}
}