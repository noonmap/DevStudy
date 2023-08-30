import java.util.*;
// Map에 따로 저장해줘야 하는 줄 알았는데 생각보다 시간 매우 넉넉함.
/*
* 병합된 셀 정보 어떻게 저장?
- 병합된 셀에 무슨 셀이 포함되어있는지
- 병합된 셀에 무슨 값이 있는지
(인접하지 않을 수 있음)
- UNMERGE하면 모두 해제되기 때문에 -> 대표 1root cell 정보만 있으면 merge표현 가능

* 셀의값 update하기 위해서는 -> 같은 값을 가진 셀 위치를 저장할 필요가 있다.
- map에 저장한 경우?
    - 값이 바뀌면 map도 수정해줘야함
    - 병합한 경우, 자식의 map값은 삭제해야함. -> map에 저장된 위치를 셀이 가지고 있어야 (양방향) -> 값 가지고 있으면 알고있는 것
    - 분해하는 경우, 부모map은 삭제, 새로운 셀은 추가해줘야 함
    

* 부모 cell정보
* 각 cell이 담고있는 문자열 정보 (자식 cell은 x)

2차원 union and find

*/

class Solution {
    static class Cell{
        Cell root;
        String value = "";
    }
    static Cell[][] table;
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        table = new Cell[51][51];
        
        // 초기화
        for(int i=1; i<51; i++){
            for(int j=1; j<51; j++){
                table[i][j] = new Cell();
                table[i][j].root = table[i][j];
            }
        }
        
        for(int i=0; i<commands.length; i++){
            String[] str = commands[i].split(" ");
            
            if(str[0].equals("UPDATE") && str.length == 4){
                int y = Integer.parseInt(str[1]);
                int x = Integer.parseInt(str[2]);
                Cell root = find(table[y][x]); // root셀 찾음
                root.value = str[3]; // cell의 값 갱신
            }
            if(str[0].equals("UPDATE") && str.length == 3){
                String priv = str[1];
                String after = str[2];
                for(int y=1; y<51; y++){
                    for(int x=1; x<51; x++){
                        if(find(table[y][x]) == table[y][x] && table[y][x].value.equals(priv)){
                            table[y][x].value = after;
                        }
                    }
                }
            }
            if(str[0].equals("MERGE")){
                int y1 = Integer.parseInt(str[1]);
                int x1 = Integer.parseInt(str[2]);
                int y2 = Integer.parseInt(str[3]);
                int x2 = Integer.parseInt(str[4]);
                merge(x1, y1, x2, y2); 
            }
            if(str[0].equals("UNMERGE")){
                int y = Integer.parseInt(str[1]);
                int x = Integer.parseInt(str[2]);
                unmerge(x, y);
            }
            if(str[0].equals("PRINT")){
                int y = Integer.parseInt(str[1]);
                int x = Integer.parseInt(str[2]);
                Cell root = find(table[y][x]);
                if(root.value.equals(""))
                    answer.add("EMPTY");
                else
                    answer.add(root.value);
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
    public static Cell find(Cell c){
        if(c.root == c) return c;
        return c.root = find(c.root);
    }
    public static void merge(int x1, int y1, int x2, int y2){
        Cell r1 = find(table[y1][x1]);
        Cell r2 = find(table[y2][x2]);
        if(r1 == r2) return;
        // 값 병합
        if(r1.value.equals("") && r2.value.length() > 0){ // r2의 값
            r1.value = r2.value;
        }
        r2.value = ""; // r2값 지움
        r2.root = r1;
    }
    public static void unmerge(int x, int y){
        // 자식들 모두 자기자신으로.
        // x,y위치만 값을 가지고 나머진 x
        Cell root = find(table[y][x]);
        String val = root.value;
        // 모두 값 초기화, root 초기화
        List<Cell> list = new ArrayList<>();
        for(int i=1; i<51; i++){
            for(int j=1; j<51; j++){
                if(find(table[i][j]) == root){
                    list.add(table[i][j]);
                    // table[i][j].root = table[i][j]; // 바로 갱신하면 중간에 parent 단절 올 수 있음
                    // table[i][j].value = "";
                }
            }
        }
        for(Cell c : list){
            c.root = c;
            c.value = "";
        }
        // x, y위치만 값 할당
        table[y][x].value = val;
    }
}