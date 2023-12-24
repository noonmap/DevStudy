import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	// *** quick sort -> 최악 n^2이므로, 시간초과남
	public static boolean cmp(int[] a, int[] b) {
		if(a[0] < b[0]) return true; // (a가 더 앞)
		if(a[0] == b[0] && a[1] <= b[1]) return true;
		return false;		
	}
	public static void swap(int[] a, int[] b) {
		int t1 = a[0], t2 = a[1];
		a[0] = b[0];
		a[1] = b[1];
		b[0] = t1;
		b[1] = t2;
	}
	public static void qsort(int[][] arr, int sidx, int eidx) {
		if(sidx >= eidx) return;
		
		int piv = sidx;
		int s = sidx+1;
		int e = eidx;
		while(s <= e) {
			while(s <= e && cmp(arr[s], arr[piv])) s++;
			while(s <= e && cmp(arr[piv], arr[e])) e--;
			if(s < e) {
				swap(arr[s], arr[e]);
			}
		}
		swap(arr[e], arr[piv]);
		piv = e;
		
		// 분할
		qsort(arr, sidx, piv-1);
		qsort(arr, piv+1, eidx);
	}
	
	// *** merge sort => 메모리 100_000 * 4 * 2 이므로 괜찮
	static int[][] mem;
	public static void copy(int[] src, int[] dest) {
		dest[0] = src[0];
		dest[1] = src[1];
	}
	public static void msort(int[][] arr, int sidx, int eidx) {
		if(sidx >= eidx) {
			return;
		}
		
		// 분할
		int mid = (sidx + eidx) >> 1;
			
		// 정복
		msort(arr, sidx, mid);
		msort(arr, mid+1, eidx);
		
		// 병합
		int a = sidx;
		int b = mid+1;
		int i=sidx;
		for(; i<=eidx && a<=mid && b<=eidx; i++) {
			if(cmp(arr[a], arr[b])) {
				copy(arr[a++], mem[i]);
			} else {
				copy(arr[b++], mem[i]);
			}
		}
		while(a <= mid) copy(arr[a++], mem[i++]);
		while(b <= eidx) copy(arr[b++], mem[i++]);
		
		for(int j=sidx; j<=eidx; j++) {
			copy(mem[j], arr[j]);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		mem = new int[N][2];
		for(int i=0; i<N; i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i][0] = x;
			arr[i][1] = y;
		}
		msort(arr, 0, N-1);
		for(int i=0; i<N; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}
	}
}