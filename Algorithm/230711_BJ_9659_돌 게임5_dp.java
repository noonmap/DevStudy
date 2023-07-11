import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] N = br.readLine().toCharArray();
		if((N[N.length-1]-'0')%2 == 0) System.out.println("CY");
		else System.out.println("SK");
//		int[] dp = new int[1001]; // [n] = n 횟수 남았을 떄 현재 사람 승리 여부 (1 : 승, 2 : 패)
//		dp[1] = 2;
//		dp[2] = 1;
//		dp[3] = 2;
//		dp[4] = 1;
//		for(int i=5; i<=N; i++) {
//			int res = Math.max(dp[i-1], Math.max(dp[i-3], dp[i-4])); // 다음 사람 하나라도 지면 승
//			dp[i] = res == 2 ? 1 : 2; 
//		}
//		if(dp[N] == 1) System.out.println("SK");
//		else System.out.println("CY");
	}
	
}
