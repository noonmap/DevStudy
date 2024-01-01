import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st  = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (a, b) -> {
			if(a[1] < b[1]) return -1;
			if(a[1] == b[1] && a[0] < b[0]) return -1;
			return 1;
		});
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1] + '\n');
		}
		System.out.println(sb.toString());
	}
}