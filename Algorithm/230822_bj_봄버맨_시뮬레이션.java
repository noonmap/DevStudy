import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int R, C, N;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for(int i=0; i<R; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<C; j++) {
				map[i][j] = line[j] == '.' ? 2 : 0;
			}
		}
		for(int n=3; n<=N; n+=2) {
			// Æø¹ß
			bomb(n-3);
		}
		StringBuilder ans = new StringBuilder();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] <= N) ans.append('O');
				else ans.append('.');
			}
			ans.append("\n");
		}
		System.out.println(ans.toString());
	}
	static int[] py = {-1, 0, 1, 0};
	static int[] px = {0, -1, 0, 1};
	public static void bomb(int s) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == s) {
					map[i][j] = s+4;
					for(int p=0; p<4; p++) {
						int ny = i + py[p];
						int nx = j + px[p];
						if(nx < 0 || nx >= C || ny < 0 || ny >= R) continue;
						if(map[ny][nx] == s) continue; // µ¿½Ã¿¡ ÅÍÁö´Â ÆøÅº
						map[ny][nx] = s+4;
					}
				}
			}
		}
	}
} 