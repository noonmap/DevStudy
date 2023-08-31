import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N, K;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 K = Integer.parseInt(st.nextToken());
		 st = new StringTokenizer(br.readLine());
		 int[] arr = new int[N];
		 int[] cnt = new int[100_001];
		 for(int i=0; i<N; i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 int answer = 0;
		 int s=0, e=0;
		 while(e < N) {
			 cnt[arr[e]]++;
			 while (cnt[arr[e]] > K) {
				 cnt[arr[s]]--;
				 s++;
			 }
			 answer = Math.max(answer, e-s+1);
			 e++;
		 }
		 System.out.println(answer);
	}
}