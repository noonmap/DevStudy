import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
		int lim = 15*28*19+1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int y=1; y<=lim; y++) {
			int e = y % 15;
			e = e == 0 ? 15 : e;
			int s = y % 28;
			s = s == 0 ? 28 : s;
			int m = y % 19;
			m = m == 0 ? 19 : m;
			if(e == E && s == S && m == M) {
				System.out.println(y);
				break;
			}
		}
	}
}