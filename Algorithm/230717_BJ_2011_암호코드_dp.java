import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = ("0" + br.readLine()).toCharArray(); // ���ڸ� ���� �ϳ� ����
		
		// ���ڿ� Ž���� �ڿ��� ������ ���� (������ ������ ���� �տ��� �����ϳ� �ڿ��� �����ϳ� ����... ���� ���� �޾Ƶ��̴� ����)
		// dp[idx] = dp[idx+1] + dp[idx+2] (str[idx] + str[idx+1] <= 26)
		// dp[idx] = dp[idx+1]             (str[idx] + str[idx+1] > 26)
		int N = str.length-1;
		int[] dp = new int[N+2];
		dp[0] = 1; // ���̵�����
		for(int n=1; n<=N; n++) {
			int b = str[n] - '0'; // �����ڸ�
			int f = str[n-1] - '0'; // ���ڸ�
			if(1 <= b && b <= 9) dp[n] = (dp[n] + dp[n-1]) % 1000000;
			if(10 <= f*10 + b && f*10 + b <= 26) dp[n] = (dp[n] + dp[n-2]) % 1000000;
		}
		System.out.println(dp[N]);
	}
}
  