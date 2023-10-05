import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		while(N-- > 0) {
			char[] word = br.readLine().toCharArray();
			boolean[] chk = new boolean['z'-'a'+1];
			chk[word[0]-'a'] = true;
			boolean ans = true;
			for(int i=1; i<word.length; i++) {
				if(word[i-1] != word[i] && chk[word[i]-'a']) {
					ans = false;
					break;
				}
				chk[word[i] - 'a'] = true;
			}
			if(ans) cnt++;
		}
		System.out.println(cnt);
		
	}
}
