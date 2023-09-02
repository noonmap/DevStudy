import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 arr = new int[N];
		 for(int i=0; i<N; i++) {
			 arr[i] = Integer.parseInt(br.readLine());
		 }
		 Arrays.sort(arr);
		 int s=0, e=0;
		 int min = 2_100_000_000;
		 while(e < N) {
			 while(s >= e || (e < N && arr[e] - arr[s] < M)) {
				 e++;
			 }
			 if(e >= N) break;
			 min = Math.min(min, arr[e] - arr[s]);
			 s++;
		 }
		 System.out.println(min);
	}
}