import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String r = br.readLine();
		int cnt=0;
		for(int i=0; i<s.length(); i++) {
			boolean g = true;
			int cur = i;
			int len = 0;
			for(int j=0; j<r.length() && cur<s.length(); j++, cur++) {
				if(s.charAt(cur) != r.charAt(j)) {
					g = false; 
					break;
				}
				len++;
			}
			if(g && len == r.length()) {
				cnt++;
				i = cur - 1;
			}
		}
		System.out.println(cnt);
	}
}