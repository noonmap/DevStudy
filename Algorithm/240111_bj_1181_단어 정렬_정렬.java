import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		Arrays.sort(arr, (a, b) -> {
			if(a.length() == b.length()) return a.compareTo(b);
			return a.length() - b.length();
		});
		System.out.println(arr[0]);
		for(int i=1; i<N; i++) {
			if(arr[i].equals(arr[i-1])) continue;
			System.out.println(arr[i]);
		}
	}
}