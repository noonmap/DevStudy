import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int L, C;
	static char[] str;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		str = new char[C];
		st = new StringTokenizer(br.readLine());		
		for(int i=0; i<C; i++) {
			str[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(str);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<C-L+1; i++) {
			if(isConsonant(str[i]))	dfs(sb, i, 1, 0, 1, 1 << i); // 현재 idx, 모음 개수, 자음 개수, 현재까지 길이
			else					dfs(sb, i, 0, 1, 1, 1 << i); // 현재 idx, 모음 개수, 자음 개수, 현재까지 길이
		}
		System.out.println(sb.toString());
	}
	public static void dfs(StringBuilder sb, int curIdx, int consonant, int vowel, int len, int bits) {
		if(len == L) {
			if(consonant >= 1 && vowel >= 2) {
				int idx=0;
				while(bits != 0) {
					if((bits & 1) == 1) sb.append(str[idx]);
					bits >>= 1;
					idx++;
				}
				sb.append("\n");
			}			
			return;
		}
		
		for(int i=curIdx+1; i<C-(L-len-1); i++) {
			if(isConsonant(str[i])) dfs(sb, i, consonant+1, vowel, len+1, bits + (1<<i));
			else 					dfs(sb, i, consonant, vowel+1, len+1, bits + (1<<i));
		}
	}
	public static boolean isConsonant(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
		return false;
	}
} 