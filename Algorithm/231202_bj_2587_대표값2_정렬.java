import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int [5];
		int sum = 0;
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		// bubble sort
		for(int i=0; i<5; i++) {
			for(int j=1; j<5-i; j++) {
				if(arr[j-1] > arr[j]) {
					int tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		System.out.println(sum / 5);
		System.out.println(arr[2]);
	}
}
