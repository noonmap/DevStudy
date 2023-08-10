import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N;
	static int[] arr;
	static int[] sarr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sarr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sarr[i] = arr[i];
		}
		
		Arrays.sort(sarr);
		for(int i=N-1; i>0; i--) {
			if(sarr[i] == sarr[i-1]) sarr[i] = 1_000_000_001; // INF
		}
		Arrays.sort(sarr);
		
		StringBuilder ans = new StringBuilder();
		for(int i=0; i<N; i++) {
			int p = binSearch(arr[i]-1);
			ans.append(p + " ");
		}
		System.out.println(ans.toString());
		
	}
	public static int binSearch(int num) { // 큰 수
		int s = 0, e = N-1;
		while(s < e) {
			int mid = (s + e) >> 1;
			if(sarr[mid] <= num) s = mid + 1;
			else e = mid;
		}
		return s;
	}
}
