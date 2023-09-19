import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for(int i=1; i<N; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int cnt=0;
		for(int i=0; i<N; i++) { // [0, j]
			if(arr[i] == M) {
				cnt++;
				break;
			}
		}
		for(int i=1; i<N; i++) { // [i, j] : arr[j] - arr[i-1] 
			for(int j=i; j<N; j++) {
				if(arr[j] - arr[i-1] == M) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}