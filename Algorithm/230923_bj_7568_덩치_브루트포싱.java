import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i][0] = x;
			arr[i][1] = y;
		}
		
		for(int i=0; i<N; i++) {
			int cnt=1;
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				if(arr[j][0] > arr[i][0] && arr[j][1] > arr[i][1]) cnt++;
			}
			System.out.println(cnt);
		}
	}
}