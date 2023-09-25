import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		do {
			for(int i=0; i<N; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		} while(np(arr));
	}
	public static boolean np(int[] arr) {
		int x = arr.length - 1;
		while(x > 0 && arr[x-1] >= arr[x]) x--;
		if(x == 0) return false;
		
		int y = arr.length - 1;
		while(arr[x-1] >= arr[y]) y--;
		swap(arr, x-1, y);
		
		int z = arr.length - 1;
		while(x < z) swap(arr, x++, z--);
		return true;
	}
	public static void swap(int[] arr, int x, int y) {
		int t = arr[x];
		arr[x] = arr[y];
		arr[y] = t;
	}
}