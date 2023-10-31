import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<2*N-1; i++) {
			int l = i < N ? i : 2*N-i-2;
			for(int b=0; b<N-l-1; b++) System.out.print(" ");
			for(int s=0; s<l*2+1; s++) System.out.print("*");
			System.out.println();
		}
	}
}