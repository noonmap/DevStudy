import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int idx = 0;
		for(int i=0; i<9; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n > max) {
				max = n;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx+1);
	}
}
