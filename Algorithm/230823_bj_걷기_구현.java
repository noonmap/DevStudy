import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static long X, Y, W, S;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		if(W > S) {
			if(X > Y) {
				long sec = Y*S;
				sec += ((X-Y)/2)*2*S;
				sec += ((X-Y)%2)*W;
				System.out.println(sec);
			} else {
				long sec = X*S;
				sec += ((Y-X)/2)*2*S;
				sec += ((Y-X)%2)*W;
				System.out.println(sec);				
			}
		}
		else if(W*2 > S) {
			if(X > Y) {
				System.out.println(Y*S + (X-Y)*W);
			} else {				
				System.out.println(X*S + (Y-X)*W);
			}
		} else {
			System.out.println((X+Y)*W);
		}
	}
}