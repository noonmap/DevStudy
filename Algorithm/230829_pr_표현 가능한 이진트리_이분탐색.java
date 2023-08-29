class Solution {
    static int[] len = {1, 3, 7, 15, 31, 63};
    static int cnt;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            String bin = numToBin(numbers[i]);
            if(enableTree(bin, 0, bin.length()-1) != -1){
                answer[i] = 1;
            } else{
                answer[i] = 0;
            }
        }
        return answer;
    }
    public static String numToBin(long num){
        // num을 이진수로 변환
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(num&1);
            num>>=1;
        }
        // 포화 이진트리의 크기에 맞춰서 이진수의 앞을 0으로 채움
        for(int i=0; i<6; i++){
            if(sb.length() == len[i]) break;
            if(sb.length() < len[i]){
                while(sb.length() < len[i]){
                    sb.append(0);
                }
                break;
            }
        }
        return sb.reverse().toString();
    }
    public static int enableTree(String bin, int si, int ei){ // 나 포함 하위노드에 있는 1의 개수를 return
        // 리프 노드인 경우
        if(si == ei) {
            return bin.charAt(si) == '1' ? 1 : 0;
        }
        // 하위노드에 1의 개수가 몇 개 있는지 구함
        int r1 = enableTree(bin, si, ((si+ei)>>1)-1);
        int r2 = enableTree(bin, ((si+ei)>>1)+1, ei);
        
        // 하위노드에서 조건을 불만족한 경우 -> -1
        if(r1 == -1 || r2 == -1) return -1;
        // 하위노드에 1이 하나라도 있다면, 부모노드는 반드시 1이어야 함
        if((r1 + r2 > 0) && bin.charAt((si+ei)>>1) == '0'){
            return -1;
        }
        // 내가 1이면 1카운트 더함
        if(bin.charAt((si+ei)>>1) == '1') r1++;
        return r1 + r2;
    }
}