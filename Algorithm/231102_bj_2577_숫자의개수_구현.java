import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int L = Integer.parseInt(br.readLine());
		int mul = N*M*L;
		int[] cnt = new int[10];
		while(mul > 0) {
			int n = mul % 10;
			cnt[n]++;
			mul /= 10;
		}
		for(int i=0; i<10; i++) {
			System.out.println(cnt[i]);
		}
	}
}