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
		dp = new int[11][10]; // [10^n][0~9개수]
		ans = new int[10];
		// dp
		for(int i=0; i<10; i++) { // 0~9숫자 중, 0,1,2...의 개수 카운트
			dp[0][i]++;
		}
		int num = 10;
		for(int i=1; i<10; i ++) { // 00~99 숫자 중 카운트, 000~999카운트, ...
			for(int j=0; j<10; j++) {
				dp[i][j] = dp[i-1][j] * 10 + num;
			}
			num *= 10;
		}
		
		int acc_num=0; // 이전자리 까지의 수
		int cur_idx=0; // 자릿수
		int pow_ten=1; // 10^n수
		// N = 529인 경우를 예제
		// 000~499까지 카운트, 500~519까지 카운트, 520~529까지 카운트함.
		// 정확히는 0~9 -> 00~19 -> 000~499 순서로 카운트.
		while(N > 0) {
			// 일의 자리 -> 십의 자리 -> 백의 자리 순으로 진행함
			// 아래 주석은 마지막인 백의 자리(500)인 경우를 가정해서 설명함
			int cur_num = N%10;
			// 100의 자리에 있는 숫자를 더함 ('0'00~'0'99, '1'00~'1'99, ... '4'00~'4'99 이므로 -> 0,1,2,3,4에 100씩 추가) 
			for(int i=0; i<cur_num; i++) ans[i] += pow_ten;
			if(cur_idx > 0) {
				// 1~10의 자리에 있는 숫자를 더함
				// (?00~?99)를 더함 : dp[idx-1] * 5
				for(int i=0; i<10; i++) ans[i] += dp[cur_idx-1][i] * cur_num;
			}
			// (앞서 백의 자리 숫자가 0~4인 수를 카운트 했으니) 마지막 백의자리 숫자인 5를 카운트함.
			// 500~529까지,30개(00~29)만큼 5가 나오므로, 그만큼 5를 더함
			ans[cur_num] += acc_num+1; // 이전자리까지 더함

			acc_num += cur_num * pow_ten;
			cur_idx++;
			pow_ten*=10;
			N /= 10;
		}
		
		// 필요없는 0 뺌
		// 000~099의 앞 0들 
		num = 1;
		for(int i=0; i<cur_idx; i++) {
			ans[0] -= num;
			num *= 10;
		}
		
		// 출력
		for(int i=0; i<10; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}