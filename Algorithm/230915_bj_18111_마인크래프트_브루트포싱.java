import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N, M, B;
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int[] hCnt = new int[257];
		int totalBlock = B;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int c = Integer.parseInt(st.nextToken());
				totalBlock += c;
				hCnt[c]++;
			}
		}
		
		int maxHeight = totalBlock / (N*M);
		int ansHeight = 0;
		// 걸리는 시간 : 최종 높이 M이라고 했을 때, 각 M을 만드는 걸리는 시간
		// M은 0~(B + 땅높이)/N*M 까지
		int minTime = 200_000_000;
		for(int h=0; h<=maxHeight; h++) {
			int time = 0;
			for(int i=0; i<257; i++) {
				if(hCnt[i] > 0) { 
					if(i < h) {// add block
						time += (h - i) * hCnt[i];
					}
					else if( i > h) { // subtract block
						time += (i - h) * hCnt[i] * 2;
					}
					
				}
			}
			if(minTime >= time) {
				minTime = time;
				ansHeight = h;
			}
		}
		System.out.println(minTime + " " + ansHeight);
	}
}