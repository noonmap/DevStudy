import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		int mod = (int)((N-1) % 5);
		if(mod == 1 || mod == 4) System.out.println("CY");
		else System.out.println("SK");
	}
	
}
