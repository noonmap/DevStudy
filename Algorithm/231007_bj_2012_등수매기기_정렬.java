import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
//		Arrays.sort(arr);
		sort(arr, 0, arr.length-1);
		
		long sum = 0;
		for(int i=0; i<N; i++) {
			sum += (long)Math.abs(i+1 - arr[i]);
		}
		System.out.println(sum);
	}
	public static void sort(int[] arr, int s, int e) {
		if(s >= e) return;
		int m = partition(arr, s, e);  // piv값의 위치를 반환
		sort(arr, s, m-1);
		sort(arr, m+1, e);
	}
	public static int partition(int[] arr, int s, int e) {
		int piv = s; // piv은 처음값
		s++;
		while(s <= e) { // 교차될 때까지
			while(s <= e && arr[s] <= arr[piv]) s++; // piv보다 작거나 같은 값 : 왼
			while(s <= e && arr[piv] < arr[e]) e--; // piv보다 큰 값 : 오
			if(s < e) {
				swap(arr, s, e);
			}
		}
		swap(arr, piv, e);	// arr[e]는 piv보다 작거나 같은 값 -> piv과 자리 바꿈.
		return e;
	}
	public static void swap(int[] arr, int s, int e) {
		int t = arr[s];
		arr[s] = arr[e];
		arr[e] = t;
	}
}