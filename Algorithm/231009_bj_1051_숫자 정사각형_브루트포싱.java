import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			char[] c = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				arr[i][j] = c[j] - '0';
			}
		}
		
		int max = 1;
		for(int i=0; i<N-1; i++) {			
			for(int j=0; j<M-1; j++) {
				int cur = arr[i][j];
				for(int k=j+1; k<M; k++) {
					if(arr[i][k] == cur) {
						// 정사각형 한 변
						int len = k - j + 1;
						if(i+len-1 < N && arr[i+len-1][j] == cur && arr[i+len-1][k] == cur) {
							max = Math.max(max, len*len);
						}
					}
				}
			}
		}
		System.out.println(max);
	}
}