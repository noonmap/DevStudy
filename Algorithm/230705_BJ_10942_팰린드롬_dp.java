import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, M;
	static int[] arr; // 칠판에 적은 수
	static int[][] palindrome; // 팰린드롬 체크 : [s][e]가 맬린드롬이면 1, 아니면 0
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수열 크기
		arr = new int[N+1]; // 칠판에 적은 수
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 질문 개수
		int[][] question = new int[M][2]; // 입출력 시간 줄이기 위해 질문 저장 
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			question[i][0] = Integer.parseInt(st.nextToken());
			question[i][1] = Integer.parseInt(st.nextToken());
		}
		
		palindrome = new int[N+1][N+1]; // 4MB * 8
		StringBuilder result = new StringBuilder(); // 결과
		for(int i=0; i<M; i++) {
			int res = isPalin(question[i][0], question[i][1]) == 1 ? 1 : 0;
			result.append(res).append('\n');
		}
		System.out.println(result.toString());
	}
	static public int isPalin(int start, int end) {
		if(palindrome[start][end] != 0) { // 이미 있으면 return
			return palindrome[start][end];
		}
		if(start == end) { // 길이 1
			palindrome[start][end] = 1;
			return 1;
		}
		if(start+1 == end) { // 길이 2
			if(arr[start] == arr[end]) {
				palindrome[start][end] = 1;
				return 1;
			}
			else {
				palindrome[start][end] = -1;
				return -1;
			}
		}
		// 길이 3이상
		if(arr[start] != arr[end]) {
			return palindrome[start][end] = -1;
		} else {
			return palindrome[start][end] = isPalin(start+1, end-1);
		}
	}
}
