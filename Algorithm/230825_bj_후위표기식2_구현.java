import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		double[] num = new double['Z'-'A'+1];
		char[] exp = br.readLine().toCharArray();
		for(int i=0; i<N; i++) {
			num[i] = Double.parseDouble(br.readLine());
		}
		
		Stack<Double> s = new Stack<>();
		for(int i=0; i<exp.length; i++) {
			if(exp[i] >= 'A' && exp[i] <= 'Z') {
				s.push(num[exp[i] - 'A']);
			} else {
				 double a = s.pop();
				 double b = s.pop();
				 double c = 0;
				 if(exp[i] == '+') c = b+a;
				 if(exp[i] == '-') c = b-a;
				 if(exp[i] == '*') c = b*a;
				 if(exp[i] == '/') c = b/a;
				 s.push(c);
//				 System.out.println(String.format("%f %c %f = %f", a, exp[i], b, c));
			}
		}
		System.out.println(String.format("%.2f", s.pop()));
	}
}