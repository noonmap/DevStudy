import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int[] visit = new int[N];
		int[] list = new int[M];
		dfs(arr, visit, list, 0, N, M);
	}
	public static void dfs(int[] arr, int[] visit, int[] list, int cnt, int N, int M) {
		if(cnt == M) {
			for(int i=0; i<M; i++) {
				System.out.print(list[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visit[i] == 1) continue;
			visit[i] = 1;
			list[cnt] = arr[i];
			dfs(arr, visit, list, cnt+1, N, M);
			visit[i] = 0;
		}
	}
}
