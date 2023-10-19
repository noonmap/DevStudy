import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			switch(order) {
			case 1:
				stk.add(Integer.parseInt(st.nextToken()));
				break;
			case 2:
				if(stk.isEmpty()) sb.append("-1\n");
				else sb.append(stk.pop()).append("\n");
				break;
			case 3:
				sb.append(stk.size()).append("\n");
				break;
			case 4:
				if(stk.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
				break;
			case 5:
				if(stk.isEmpty()) sb.append(-1).append("\n");
				else sb.append(stk.peek()).append("\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}