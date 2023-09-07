import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N, M, K;
	static int totalSum, totalCost;
	static int[] memoi;
	static class App{
		int m, c;

		@Override
		public String toString() {
			return "App [m=" + m + ", c=" + c + "]";
		}
	}
	static App[] apps;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		apps = new App[N];
		for(int i=0; i<N; i++) apps[i] = new App();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			apps[i].m = Integer.parseInt(st.nextToken());
			totalSum += apps[i].m;
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			apps[i].c = Integer.parseInt(st.nextToken());
			totalCost += apps[i].c;
		}
		
		// 무게 순으로 정렬
		Arrays.sort(apps, (a, b) -> a.m - b.m);
		
		// totalSum - M 무게 이내에서, 비용을 최대화해서 골라냄 -> 남아있어야 할 앱
		K = totalSum - M;
		memoi = new int[K+1]; // [K무게일 때 최대비용]
		// 제일 작은 무게로 초기화
		for(int i=apps[0].m; i<=K; i++) {
			memoi[i] = apps[0].c;
		}
		for(int n=1; n<N; n++) {
			for(int k=K; k>=apps[n].m; k--) {
				memoi[k] = Math.max(memoi[k], memoi[k - apps[n].m] + apps[n].c);				
			}
		}
		System.out.println(totalCost - memoi[K]);
	}
}