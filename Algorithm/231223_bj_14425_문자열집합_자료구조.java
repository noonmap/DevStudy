import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> narr = new TreeSet<>();
		for(int i=0; i<N; i++) {
			narr.add(br.readLine());
		}
		int count = 0;
		for(int i=0; i<M; i++) {
			if(narr.contains(br.readLine())) count++;
		}
		System.out.println(count);
	}
}