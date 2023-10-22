import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int minMismatchCount = 100;
		for(int b=0; b<B.length() - A.length()+1; b++) {
			int count = 0;
			for(int a=0; a<A.length(); a++) {
				if(A.charAt(a) != B.charAt(b+a)) {
					count++;
				}
			}
			
			if(count < minMismatchCount) {
				minMismatchCount = count;
			}
		}
		System.out.println(minMismatchCount);
	}
}
