import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		int[] vip = new int[M+1];
		for(int i=0; i<M; i++) {
			vip[i] = Integer.parseInt(br.readLine());
		}
		vip[M] = N+1; // 마지막 사람 끝난 후, result에 반영하기 위해
		
		int[][] dp = new int[N+2][3]; // [좌석번호][0:왼쪽좌석입장,1:본래좌석입장,2:오른쪽좌석입장] = 시작~끝번호가 이렇게 앉을 경우의 수
		// 시작 ~ 끝 번호는 1~vip번사이, vip~vip번 사이 등 자리 바꿀 수 있는 좌석의 시작과 끝을 의미
		dp[0][1] = 1;
		int vipIdx = 0;
		int result = 1;
		for(int i=1; i<=N+1; i++) { // N+1번은 N번째 사람 끝난 후, if문에서 자동으로 result에 마지막 경우의 수를 반영하기 위해
			// vip인 경우 -> 이전까지 구한 경우의수 곱함, continue;
			if(vip[vipIdx] == i) {
				vipIdx++;
				result *= (dp[i-1][0] + dp[i-1][1]);
				dp[i][1] = 1;
				continue;
			}
			dp[i][0] = dp[i-1][2];
			dp[i][2] = dp[i][1] = dp[i-1][0] + dp[i-1][1];
		}
		System.out.println(result);
	}
}
