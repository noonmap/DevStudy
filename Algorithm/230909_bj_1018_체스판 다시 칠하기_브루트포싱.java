import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N, M;
	static char[][] arr;
	static char[][][] ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		int min=100_000_000;
		char[] chr = {'W', 'B'};
		for(int i=0; i<N-7; i++) {
			for(int j=0; j<M-7; j++) {
				for(int sidx=0; sidx<2; sidx++) {					
					int cnt=0;
					int idx=sidx;
					for(int y=i; y<i+8; y++) {
						for(int x=j; x<j+8; x++) {
							if(arr[y][x] != chr[idx]) cnt++;
							idx = (idx+1)&1;
						}
						idx = (idx+1)&1;
					}
					min = Math.min(min, cnt);
				}
			}
		}
		System.out.println(min);
	}
}