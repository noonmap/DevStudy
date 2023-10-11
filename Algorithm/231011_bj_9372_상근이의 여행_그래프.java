import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			// 가중치 1이라서 무조건 나라-1개 비행기만 타면 됨
			for(int i=0; i<M; i++) br.readLine();
			System.out.println(N-1);
			// 가중치 다를 땐 프림 알고리즘(아래)
//			List<Integer>[] arr = new ArrayList[N+1];
//			for(int i=1; i<N+1; i++) arr[i] = new ArrayList<>();
//			for(int i=0; i<M; i++) {
//				st = new StringTokenizer(br.readLine());
//				int a = Integer.parseInt(st.nextToken());
//				int b = Integer.parseInt(st.nextToken());
//				arr[a].add(b);
//				arr[b].add(a);
//			}
//			
//			int[] visit = new int[N+1];
//			Queue<Integer> q = new ArrayDeque<>();
//			q.add(1);
//			int sum = 0;
//			while(!q.isEmpty()) {
//				int cur = q.remove();
//				if(visit[cur] == 1) continue;
//				visit[cur] = 1;
//				sum++;
//				for(int j=0; j<arr[cur].size(); j++) {
//					int nxt = arr[cur].get(j);
//					if(visit[nxt] == 1) continue;
//					q.add(nxt);
//				}
//			}
//			System.out.println(sum-1);
		}
	}
}