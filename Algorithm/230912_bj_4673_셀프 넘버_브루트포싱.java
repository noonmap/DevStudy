import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N, len;
	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10_000];
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				for(int k=0; k<10; k++) {
					for(int l=0; l<10; l++) {
						int n = i*1000 + j*100 + k*10 + l + i + j + k + l;
						if(n < 10000) arr[n] = 1;
					}
				}
			}
		}
		for(int i=1; i<10000; i++) 
			if(arr[i] == 0) System.out.println(i);
	}
}