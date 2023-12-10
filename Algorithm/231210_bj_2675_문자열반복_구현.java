import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<S.length(); i++) {
				char c = S.charAt(i);
				for(int r=0; r<R; r++) {
					sb.append(c);
				}
			}
			System.out.println(sb.toString());
		}
	}
}
