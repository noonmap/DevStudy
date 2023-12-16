import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int[] arr  = new int[num.length()];
		for(int i=0; i<num.length(); i++) {
			arr[i] = num.charAt(i) - '0';
		}
		Arrays.sort(arr);
		for(int i=arr.length-1; i>=0; i--) {
			System.out.print(arr[i]);
		}
	}
}