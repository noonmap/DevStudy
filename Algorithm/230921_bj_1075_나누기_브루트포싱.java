import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		N /= 100;
		N *= 100;
		int i=0;
		for(i=0; i<100; i++) {
			if((N+i) % M == 0) break; 
		}
		if(i < 10) System.out.println("0" + i);
		else System.out.println(i);
	}
}