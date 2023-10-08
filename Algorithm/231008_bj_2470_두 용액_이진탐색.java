import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		// piv기준, piv+1 ~ end중 |piv - arr| 가 가장 작은 것
		int a=0, b=0;
		int ans = 2_100_000_000;
		for(int p=0; p<arr.length-1; p++) {
			int ano = find(arr, arr[p], p+1, arr.length-1);
			if(ans > Math.abs(arr[p] + arr[ano])) {
				a = arr[p];
				b = arr[ano];
				ans = Math.abs(arr[p] + arr[ano]);
			}
		}
		System.out.println(a + " " + b);
	}
	public static int find(int[] arr, int piv, int s, int e) {
		while(s < e) {
			int m = (s+e) >> 1;
			if(calc(piv,arr[m]) > calc(piv,arr[m+1])) s = m+1;
			else e = m;
		}
		return s;
	}
	public static int calc(int a, int b) {
		return Math.abs(a+b);
	}
}