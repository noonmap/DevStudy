import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N;
	static int[][] dp;
	static int[] ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[11][10]; // [10^n][0~9����]
		ans = new int[10];
		// dp
		for(int i=0; i<10; i++) { // 0~9���� ��, 0,1,2...�� ���� ī��Ʈ
			dp[0][i]++;
		}
		int num = 10;
		for(int i=1; i<10; i ++) { // 00~99 ���� �� ī��Ʈ, 000~999ī��Ʈ, ...
			for(int j=0; j<10; j++) {
				dp[i][j] = dp[i-1][j] * 10 + num;
			}
			num *= 10;
		}
		
		int acc_num=0; // �����ڸ� ������ ��
		int cur_idx=0; // �ڸ���
		int pow_ten=1; // 10^n��
		// N = 529�� ��츦 ����
		// 000~499���� ī��Ʈ, 500~519���� ī��Ʈ, 520~529���� ī��Ʈ��.
		// ��Ȯ���� 0~9 -> 00~19 -> 000~499 ������ ī��Ʈ.
		while(N > 0) {
			// ���� �ڸ� -> ���� �ڸ� -> ���� �ڸ� ������ ������
			// �Ʒ� �ּ��� �������� ���� �ڸ�(500)�� ��츦 �����ؼ� ������
			int cur_num = N%10;
			// 100�� �ڸ��� �ִ� ���ڸ� ���� ('0'00~'0'99, '1'00~'1'99, ... '4'00~'4'99 �̹Ƿ� -> 0,1,2,3,4�� 100�� �߰�) 
			for(int i=0; i<cur_num; i++) ans[i] += pow_ten;
			if(cur_idx > 0) {
				// 1~10�� �ڸ��� �ִ� ���ڸ� ����
				// (?00~?99)�� ���� : dp[idx-1] * 5
				for(int i=0; i<10; i++) ans[i] += dp[cur_idx-1][i] * cur_num;
			}
			// (�ռ� ���� �ڸ� ���ڰ� 0~4�� ���� ī��Ʈ ������) ������ �����ڸ� ������ 5�� ī��Ʈ��.
			// 500~529����,30��(00~29)��ŭ 5�� �����Ƿ�, �׸�ŭ 5�� ����
			ans[cur_num] += acc_num+1; // �����ڸ����� ����

			acc_num += cur_num * pow_ten;
			cur_idx++;
			pow_ten*=10;
			N /= 10;
		}
		
		// �ʿ���� 0 ��
		// 000~099�� �� 0�� 
		num = 1;
		for(int i=0; i<cur_idx; i++) {
			ans[0] -= num;
			num *= 10;
		}
		
		// ���
		for(int i=0; i<10; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}