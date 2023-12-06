import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int i=0; i<K; i++) {
			sum += arr[i];
		}
		int max = sum;
		for(int i=K, j=0; i<N; i++, j++) {
			sum -= arr[j];
			sum += arr[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}