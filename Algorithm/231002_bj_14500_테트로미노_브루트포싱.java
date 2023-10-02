import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 시작점을 기준으로 나올 수 있는 모든 테트로미노를 구한다.
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// ㅗ ㅜ ㅓ ㅏ
		int[][] px = {{1, 1, 2}, {1, 1, 2}, {1, 1, 1}, {0, 1, 0},
		// ㅣ ㅡ ㅁ
					{0, 0, 0}, {1, 2, 3}, {1, 1, 0},
		// ㄴ
					{0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0},
		// ㄱ 
					{1, 2, 2}, {1, 2, 2}, {0, 1, 2}, {0, 1, 2},
		// ㄴㄱ
					{0, 1, 1}, {0, -1, -1}, {1, 1, 2}, {1, 1, 2}};
		
		int[][] py = {{0, -1, 0}, {0, 1, 0}, {-1, 0, 1}, {-1, 0, 1},
					{1, 2, 3}, {0, 0, 0}, {0, 1, 1},
					{1, 2, 2}, {1, 2, 2}, {0, 1, 2}, {0, 1, 2},
					{0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0},
					{1, 1, 2}, {1, 1, 2}, {0, 1, 1}, {0, -1, -1}};
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int p=0; p<19; p++) {
					int sum = arr[i][j];
					boolean valid = true;
					
					for(int d=0; d<3; d++) {
						int nx = j + px[p][d];
						int ny = i + py[p][d];
						if(nx < 0 || nx >= M || ny < 0 || ny >= N) {
							valid = false;
							break;
						}
						sum += arr[ny][nx];
						
					}
					if(valid) {
						ans = Math.max(ans, sum);
					}
				}
			}
		}
		System.out.println(ans);
		
	}
}
