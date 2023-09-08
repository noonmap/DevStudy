import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 1;
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(arr[idx-1] < n) arr[idx++] = n;
			else {	// 마지막 >= n			
				// lower bound
				for(int d=idx-1; d>=0; d--) {
					if(arr[d] < n) {
						arr[d+1] = n;
						break;
					}
				}
			}
		}
		System.out.println(idx-1);
	}
}