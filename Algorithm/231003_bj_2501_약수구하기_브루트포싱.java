import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cnt=0;
		for(int i=1; i<=N; i++) {
			if(N % i == 0) {
				cnt++;
				if(cnt == M) {
					System.out.println(i);
					break;
				}
			}
		}
		if(cnt < M) {
			System.out.println(0);
		}
	}
}
