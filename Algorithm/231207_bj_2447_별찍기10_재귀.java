import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] pic = new char[N][N];
		draw(pic, 0, 0, N);
		for(int i=0; i<N; i++) {
			System.out.println(pic[i]);
		}
	}
	public static void draw(char[][] pic, int x, int y, int size) {
		if(size == 3) {
			for(int i=x; i<x+size; i++) {
				pic[y][i] = '*';
				pic[y+1][i] = '*';
				pic[y+2][i] = '*';
			}
			pic[y+1][x+1] = ' ';
			return;
		}
		int nsize = size/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i == 1 && j == 1) {
					// blank
					for(int k=0; k<nsize; k++) {
						for(int l=0; l<nsize; l++) {
							pic[y+nsize+k][x+nsize+l] = ' ';
						}
					}
				}
				else draw(pic, x+j*nsize, y+i*nsize, nsize);
			}
		}
	}
}
