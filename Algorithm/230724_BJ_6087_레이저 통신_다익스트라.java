import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int W, H; // 1~100
	static Point start, end;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		
		for(int i=0; i<H; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<W; j++) {
				if(map[i][j] == 'C') {
					if(start == null) {
						start = new Point(j, i);
					} else {
						end = new Point(j, i);
					}
				}
			}
		}
		
		// bfs -> �� ��ġ�� �������� �� �ſ� �ּ� ���� ���� ����ġ��
		int minMirror = bfs();
		System.out.println(minMirror);
	}
	static class Ver{
		Point point;
		int vec;
		int mirror;
		public Ver(Point p, int v, int m) {
			point = p;
			vec = v;
			mirror = m;
		}
	}
	public static int bfs() {
		PriorityQueue<Ver> pq = new PriorityQueue<>((a, b) -> a.mirror - b.mirror);
		int[][][] minCheck = new int[H][W][5]; // �� ���⿡ ���� �ſ� �ּڰ��� ������. -> ���� ���⿡�� �Դµ� �ߺ� ����Ǵ� �� ����.
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				minCheck[i][j][0] = 100_000; // MAX
				minCheck[i][j][1] = 100_000; // MAX
				minCheck[i][j][2] = 100_000; // MAX
				minCheck[i][j][3] = 100_000; // MAX
				minCheck[i][j][4] = 100_000; // 0~3���� �� ��ü �ּڰ�
			}
		}
		
		minCheck[start.y][start.x][0] = 0;
		minCheck[start.y][start.x][1] = 0;
		minCheck[start.y][start.x][2] = 0;
		minCheck[start.y][start.x][3] = 0;
		minCheck[start.y][start.x][4] = 0;
		int[] px = {-1, 0, 1, 0};
		int[] py = {0, -1, 0, 1};
		
		// ������ġ���� 4 �������� ��� ����
		for(int p=0; p<4; p++) {
			int nx = start.x + px[p];
			int ny = start.y + py[p];
			if(nx < 0 || nx >= W || ny < 0 || ny >= H) continue;
			if(map[ny][nx] == '*') continue; //���̸� X
			minCheck[ny][nx][p] = 0;
			minCheck[ny][nx][4] = 0;
			if(nx == end.x && ny == end.y) return 0; // �����̸� �ٷ� ����
			pq.add(new Ver(new Point(nx, ny), p, 0));
		}
		
		while(!pq.isEmpty()) {
			Ver curv = pq.remove();
			Point cur = curv.point;
			int curvec = curv.vec;
			int curMinMirror = curv.mirror;
			// �ѹ� �ɷ���
			if(curMinMirror > minCheck[cur.y][cur.x][4]) continue;
			// �����̸� ����
			if(cur.equals(end)) break;
			
			for(int p=0; p<4; p++) {
				int nx = cur.x + px[p];
				int ny = cur.y + py[p];
				int nxtMinMirror = curMinMirror;
				if(nx < 0 || nx >= W || ny < 0 || ny >= H) continue;
				if(map[ny][nx] == '*') continue; //���̸� X
				
				if((p+2)%4 == curvec) continue; // ������ �ݴ�����̸� ����
				if(p != curvec) nxtMinMirror++; // 90�� ȸ�� -> �ſ� �߰�
				
				if(minCheck[ny][nx][4] < nxtMinMirror || minCheck[ny][nx][p] <= nxtMinMirror) continue; // ���� �湮�� �ſ� �� ���� ��������� -> ���� ��Ʈ �� �������� ����
				minCheck[ny][nx][p] = nxtMinMirror; // �ſ� ���� ����
				minCheck[ny][nx][4] = nxtMinMirror; // �ſ� ���� ����
				pq.add(new Ver(new Point(nx, ny), p, nxtMinMirror));
			}
		}
		return minCheck[end.y][end.x][4];
		
	}
}
  