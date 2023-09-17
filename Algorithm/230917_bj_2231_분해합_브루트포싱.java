import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// M + M%10 + M%100 + M%1000 + ... = N
		for(int i=1; i<1_000_001; i++) {
			int sum = i;
			int n = i;
			while(n > 0) {
				sum += n % 10;
				n /= 10;
			}
			if(sum == N) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}
}
