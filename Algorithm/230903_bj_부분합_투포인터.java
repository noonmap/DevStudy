import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N, S;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 S = Integer.parseInt(st.nextToken());
		 st = new StringTokenizer(br.readLine());
		 arr = new int[N];
		 for(int i=0; i<N; i++) {
			 arr[i] = Integer.parseInt(st.nextToken());
		 }
		 int s = 0, e = 0;
		 int sum = 0;
		 int shortest = 100_001;
		 while(s < N && e < N) {
			 while(sum < S && e < N) { // sum>=S || e==N  /// sum < S, e==N
				 sum += arr[e];
				 e++;
			 }
			 while(sum >= S && s < e) { // sum < S, s==e /// sum < S, s==N
				 sum -= arr[s];
				 s++;
			 }
//			 System.out.println(String.format("s : %d, e : %d, sum : %d", s, e, sum));
			 if(s > 0 && sum + arr[s-1] >= S) 
				 shortest = Math.min(shortest, e-s+1);
		 }
		 if(shortest == 100_001) System.out.println(0);
		 else  System.out.println(shortest);
	}
}