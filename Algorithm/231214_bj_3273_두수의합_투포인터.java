import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] mem = new int[1_000_001];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			mem[arr[i]]++;
		}
		
		int X = Integer.parseInt(br.readLine());
		
		int cnt=0;
		for(int i=0; i<N-1; i++) {
			mem[arr[i]]--;
			if(arr[i] > X) {
				continue;
			}
			cnt += mem[X-arr[i]];
		}
		System.out.println(cnt);
	}
}