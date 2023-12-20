import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] inorder = new int[N];
		int[] postorder = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		maketree(sb, inorder, postorder, 0, 0, N);
		System.out.println(sb.toString());
	}
	public static int getRoot(int[] postorder, int sidx, int len) {
		return postorder[sidx + len - 1];
	}
	public static int getRootIdx(int[] inorder, int root, int sidx, int len) {
		int i = -1;
		for(i=sidx; i<sidx+len; i++) {
			if(inorder[i] == root) break;
		}
		return i;
	}
	public static void maketree(StringBuilder sb, int[] inorder, int[] postorder, int in_sidx, int post_sidx, int len) { // root - left root - right root 순으로 탐색
		// leaf node 기저 조건
		if(len <= 1) {
//			System.out.print(inorder[in_sidx] + " ");
			sb.append(inorder[in_sidx]).append(" ");
			return;
		}
		// postorder에서 root 찾
		int root = getRoot(postorder, post_sidx, len);
		
		// (preorder 순서 상) root 출력
		sb.append(root).append(" ");
//		System.out.print(root + " ");
		
		// inorder에서 root 위치 찾
		int rootIdx = getRootIdx(inorder, root, in_sidx, len);
		int leftlen = rootIdx - in_sidx;
		int rightlen = len - leftlen - 1;
		
		// root기준 left 범위에서 재귀
		if(leftlen > 0)
			maketree(sb, inorder, postorder, in_sidx, post_sidx, leftlen);
		
		// root기준 right 범위에서 재귀
		if(rightlen > 0)
			maketree(sb, inorder, postorder, rootIdx+1, post_sidx+leftlen, rightlen);
	}
}