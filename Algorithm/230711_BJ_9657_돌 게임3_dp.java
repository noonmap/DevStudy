import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1001]; // 1 : [n] 남은 횟수 만큼 했을 때 짐 2 : [n] 남은 횟수 만큼 했을 때 이김
		dp[1] = 2; // n남은 횟수 중, 현재 사람 이김
		dp[2] = 1; // n남은 횟수 중, 현재 사람 짐
		dp[3] = 2; // 3 or 111
		dp[4] = 2; // 4
		for(int i=5; i<=1000; i++) {
			if(Math.min(dp[i-1], Math.min(dp[i-3], dp[i-4])) == 1) // 다음 사람이 지는(1)게 하나라도 있으면 -> 2(이김)
				dp[i] = 2;
			else dp[i] = 1;
		}
		if(dp[N] == 2) System.out.println("SK");
		else System.out.println("CY");
	}
	
}
