import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		float[] arr = new float[N];
		float max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Float.parseFloat(st.nextToken());
			max = Float.max(arr[i], max);
		}
		float sum = 0;
		for(int i=0; i<N; i++) {
			sum += arr[i] / max * 100.0;
		}
		System.out.println(sum / N);
	}
}