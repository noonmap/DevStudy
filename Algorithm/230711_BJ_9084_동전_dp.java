import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int T, N, M; // 테케 수, 코인 종류 수, 만들어야 할 금액
	static int[] coin; // 코인 종류 저장
	static int[] memoi; // [만들어야 할 금액] = 동전으로 만들 수 있는 총 경우의 수
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			N = Integer.parseInt(br.readLine());
			coin = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine());
			memoi = new int[M+1];
			
			memoi[0] = 1; // m == coin[c]일 땐 1가지 경우의 수가 반드시 포함되므로
			for(int c=0; c<N; c++) {
				for(int m=coin[c]; m<=M; m++) {
					memoi[m] += memoi[m - coin[c]];
				}
			}
			System.out.println(memoi[M]);
		}
	}
	
}
