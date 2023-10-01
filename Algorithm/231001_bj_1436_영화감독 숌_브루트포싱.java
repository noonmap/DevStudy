import java.io.*;
import java.util.*;
import java.awt.Point;


public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		SortedSet<Integer> set = new TreeSet<>();
		// 숫자 1개 추가 : 앞10(0~9), 뒤10(0~9) -> 20개
		for(int i=0; i<10; i++) { // 중복 : 6666
			set.add(i*1000 + 666);
			set.add(6660 + i);
		} 
		
		// 숫자 1+1개 추가 : 9*10 -> 90개
		for(int i=1; i<10; i++) {
			for(int j=0; j<10; j++) {
				set.add(i*10000 + 6660 + j);
			}
		}
		// 숫자 2개 추가 : 앞90(10~99), 뒤100(00~99) -> 180개
		// 중복 : 66666
		for(int i=10; i<100; i++) {
			set.add(i*1000 + 666);
		}
		for(int j=0; j<100; j++) {
			set.add(66600 + j);
		}
		
		
		// 중복 : 666600, 666660, 606666, 666666
		// 666600 : 6/666/00, 666/600
		// 666660 : 6/666/60, 66/6666/0, 666/660
		// 606666 : 60/666/6, 606/666
		// 666666 : 666/666, 66/666/6, 6/666/66, 666/666
		// 숫자 1+2개 추가 : 10*100 -> 1000
		for(int i=1; i<10; i++) {
			for(int j=0; j<100; j++) {
				set.add(i*100000 + 66600 + j);
			}
		}
		// 숫자 2+1 : 100*10 -> 1000
		for(int i=10; i<100; i++) {
			for(int j=0; j<10; j++) { // 2+1
				set.add(i*10000 + 6660 + j);
			}
			for(int j=0; j<100; j++) { // 2+2
				set.add(i*100000 + 66600 + j);
			}
		}
		// 숫자 3개 추가 : 앞900(100~999), 뒤1000(000~999) -> 1800개
		for(int i=100; i<1000; i++) {
			set.add(i*1000 + 666);
			for(int j=0; j<10; j++) { // 3+1
				set.add(i*10000 + 6660 + j);
			}
		}
		for(int j=0; j<1000; j++) {
			set.add(666000 + j);
			for(int i=1; i<10; i++) { // 1+3
				set.add(i*1000000 + 666000 + j);
			}
		}
		
		
		
		// 숫자 0+4
		for(int j=0; j<10000; j++) {
			set.add(6660000 + j);
		}
		// 숫자 1+3
		// 숫자 2+2
		// 숫자 3+1
		// 숫자 4+0
		// 숫자 4개 추가 : 앞9000, 뒤9000 -> 18000개
		for(int i=1000; i<10000; i++) {
			set.add(i*1000 + 666);
		}
		
		Integer[] arr = set.toArray(new Integer[set.size()]);
		System.out.println(arr[N-1]);
	}
}