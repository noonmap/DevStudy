import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N;
	static int[][] arr; // {T, P}를 저장
	static int[] dp; // 각 day의 max Price를 저장
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1][2];
		dp = new int[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int day=N; day>0; day--) { // 뒤에서부터 진행
			int p1 = 0; // p1 : day날 상담을 포함하는 경우
			int consultTime = arr[day][0]-1; 
			if(day + consultTime <= N) { // 상담 시간이 N일 이하에 가능하면 포함, 아니면 상담 못하므로 0
				p1 = arr[day][1];
				if(day+consultTime+1 <= N) { // day날 상담 끝난 다음날의 max price를 더함
					p1 += dp[day+consultTime+1];
				}
			}
			
			int p2 = day+1 <= N ? dp[day+1] : 0; // p2 : day날 상담을 포함하지 않는 경우 : 다음날 max price를 더함
			
			dp[day] = Math.max(p1, p2);
		}
		System.out.println(dp[1]); // 첫날까지 dp값을 구했을 때, max price를 구함 
	}
}
