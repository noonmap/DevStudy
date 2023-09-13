import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int max = 0;
		do {
			int sum = 0;
			for(int i=0; i<N-1; i++) {
				sum += Math.abs(arr[i] - arr[i+1]);
			}
			max = Math.max(max, sum);
		}while(np());
		
		System.out.println(max);
	}
	public static boolean np() {
		int i = arr.length - 1;
		while(i > 0 && arr[i-1] >= arr[i]) i--;
		if(i == 0) return false;
		
		int j = arr.length - 1;
		while(arr[i-1] >= arr[j]) j--;
		swap( i-1, j);
		
		int k = arr.length - 1;
		while(i < k) swap( i++, k--);
		return true;
	}
	public static void swap(int i, int k) {
		int t = arr[i];
		arr[i] = arr[k];
		arr[k] = t;
	}
}
