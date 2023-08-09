import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N, M;
	static int[] univ;
	static int[] twoSum;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		univ = new int[N];
		twoSum = new int[N*N];
		
		for(int i=0; i<N; i++) {
			univ[i] = Integer.parseInt(br.readLine());
		}
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				twoSum[cnt++] = univ[i] + univ[j];
			}
		}
		
		Arrays.sort(univ);
		Arrays.sort(twoSum);
		
		int find = 0;
		for(int i=N-1; i>=0; i--) {
			for(int j=i; j>=0; j--) {
				if(binSearch(cnt, univ[i] - univ[j])) {
					System.out.println(univ[i]);
					find = 1;					
					break;
				}
			}
			if(find == 1) break;
		}
	}
	public static boolean binSearch(int cnt, int a) {
		int s= 0, e = cnt-1;
		while(s < e) {
			int mid = (s + e ) >> 1;
			if(twoSum[mid] < a) s = mid+1;
			else e = mid;
		}
		if(twoSum[s] == a) return true;
		else return false;
	}
}