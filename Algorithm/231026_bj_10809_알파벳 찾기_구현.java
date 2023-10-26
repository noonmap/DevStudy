import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = br.readLine();
		int[] cnt = new int['z'-'a'+1];
		for(int i=0; i<'z'-'a'+1; i++) {
			cnt[i] = 10000;
		}
		for(int i=0; i<s.length(); i++) {
			int c = s.charAt(i);
			cnt[c-'a'] = Math.min(i, cnt[c-'a']);
		}
		for(int i=0; i<'z'-'a'+1; i++) {
			if(cnt[i] == 10000) System.out.print(-1);
			else System.out.print(cnt[i]);
			System.out.print(" ");
		}
	}
}
