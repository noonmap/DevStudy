import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);
		
		boolean end = false;
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if(arr[i] + arr[j] == sum - 100) {
					for(int k=0; k<9; k++) {
						if(k == i || k == j) continue;
						System.out.println(arr[k]);
					}
					end = true;
					break;
				}
			}
			if(end) break;
		}
	}
}