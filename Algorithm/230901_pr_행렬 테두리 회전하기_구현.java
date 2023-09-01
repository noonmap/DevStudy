import java.util.*;
class Solution {
    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        // 초기화
        arr = new int[rows][columns];
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j] = i * columns + j+1;
            }
        }
        int[] answer = new int[queries.length];
        for(int q=0; q<queries.length; q++){
            answer[q] = rotate(queries[q]);
            // print(rows);
        }
        return answer;
    }
    public static int rotate(int[] query){
        int y1 = query[0]-1, x1 = query[1]-1, y2 = query[2]-1, x2 = query[3]-1;
        int first = arr[y1][x1];
        int min = first;
        for(int y=y1; y<y2; y++){ // left
            min = Math.min(min, arr[y][x1]);
            arr[y][x1] = arr[y+1][x1];
        }
        for(int x=x1; x<x2; x++){ // bottom
            min = Math.min(min, arr[y2][x]);
            arr[y2][x] = arr[y2][x+1];
        }
        for(int y=y2; y>y1; y--){ // right
            min = Math.min(min, arr[y][x2]);
            arr[y][x2] = arr[y-1][x2];
        }
        for(int x=x2; x>x1; x--){ // top
            min = Math.min(min, arr[y1][x]);
            arr[y1][x] = arr[y1][x-1];
        }
        arr[y1][x1+1] = first;        
        return min;
    }
    public static void print(int rows){
        for(int i=0; i<rows; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println();
    }
}