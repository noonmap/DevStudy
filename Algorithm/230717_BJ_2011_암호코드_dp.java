import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = ("0" + br.readLine()).toCharArray(); // 앞자리 더미 하나 넣음
		
		// 문자열 탐색을 뒤에서 앞으로 진행 (하지만 따지고 보면 앞에서 진행하나 뒤에서 진행하나 같음... 문제 이해 받아들이는 차이)
		// dp[idx] = dp[idx+1] + dp[idx+2] (str[idx] + str[idx+1] <= 26)
		// dp[idx] = dp[idx+1]             (str[idx] + str[idx+1] > 26)
		int N = str.length-1;
		int[] dp = new int[N+2];
		dp[0] = 1; // 더미데이터
		for(int n=1; n<=N; n++) {
			int b = str[n] - '0'; // 현재자리
			int f = str[n-1] - '0'; // 앞자리
			if(1 <= b && b <= 9) dp[n] = (dp[n] + dp[n-1]) % 1000000;
			if(10 <= f*10 + b && f*10 + b <= 26) dp[n] = (dp[n] + dp[n-2]) % 1000000;
		}
		System.out.println(dp[N]);
	}
}
  