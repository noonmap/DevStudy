import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N, len;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int tmp = N;
		while(tmp > 0) {
			len ++;
			tmp /= 10;
		}
		if(len <= 2) {
			System.out.println(N);
		}
		else {	
			int cnt = 99;
			for(int l=3; l<=len; l++) {
				for(int start = 1; start<=9; start++)
					for(int abs=-4; abs<=4; abs++) 
						cnt += dfs(l-1, start, abs, start);
			}
			System.out.println(cnt);
		}
	}
	public static int dfs(int len, int cur, int abs, int sum) {
		if(len == 0) {
			if(sum <= N) return 1;
			else return 0;
		}
		int cnt=0;
		if(cur + abs >= 0 && cur + abs < 10) {
			cnt = dfs(len-1, cur+abs, abs, sum*10 + cur+abs);
		}
		return cnt;
	}
}