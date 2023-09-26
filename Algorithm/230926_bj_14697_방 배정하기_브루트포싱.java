import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean answer = false;
		for(int a=0; a*A<=N; a++) {
			int ra = N - a*A;
			for(int b=0; b*B<=ra; b++) {
				int rb = ra - b*B;
				for(int c=0; c*C <= rb; c++) {
					if(rb-c*C == 0) {
						answer = true;
						break;
					}
				}
				if(answer) break;
			}
			if(answer) break;
		}
		if(answer) System.out.println(1);
		else System.out.println(0);
	}
}