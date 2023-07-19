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
		vip[M] = N+1; // ������ ��� ���� ��, result�� �ݿ��ϱ� ����
		
		int[][] dp = new int[N+2][3]; // [�¼���ȣ][0:�����¼�����,1:�����¼�����,2:�������¼�����] = ����~����ȣ�� �̷��� ���� ����� ��
		// ���� ~ �� ��ȣ�� 1~vip������, vip~vip�� ���� �� �ڸ� �ٲ� �� �ִ� �¼��� ���۰� ���� �ǹ�
		dp[0][1] = 1;
		int vipIdx = 0;
		int result = 1;
		for(int i=1; i<=N+1; i++) { // N+1���� N��° ��� ���� ��, if������ �ڵ����� result�� ������ ����� ���� �ݿ��ϱ� ����
			// vip�� ��� -> �������� ���� ����Ǽ� ����, continue;
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
