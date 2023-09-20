import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int cnt = 0;
		int min = 100_000;
		int sum = 0;
		
		for(int i=1; i<101; i++) {
			int pow = i*i;
			if(pow >= N && pow <= M) {
				if(min == 100_000) min = pow;
				sum += pow;
				cnt++;
			}
			if(pow > M) break;
		}
		if(cnt == 0) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}