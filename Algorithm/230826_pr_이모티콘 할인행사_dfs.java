class Solution {
    static int maxRegister = 0;
    static int maxCost = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0,0};
        
        int[] paySum = new int[users.length];
        dfs(0, paySum, users, emoticons); // emoIdx, int[] paySum, uesrs, emoticons
        
        answer[0] = maxRegister;
        answer[1] = maxCost;
        return answer;
    }
    public static void dfs(int eIdx, int[] paySum, int[][] users, int[] emoticons){
        if(eIdx == emoticons.length){
            int register = 0;
            int cost = 0;
            for(int u=0; u<users.length; u++){
                if(paySum[u] >= users[u][1]){
                    register ++;
                } else{
                    cost += paySum[u];
                }
            }
            if(maxRegister < register){
                maxRegister = register;
                maxCost = cost;
            } else if(maxRegister == register && maxCost < cost){
                maxCost = cost;
            }
            return;
        }
        
        for(int s=1; s<5; s++){ // sale rate
            int[] tmpSum = paySum.clone();
            
            for(int u=0; u<users.length; u++){
                if(users[u][0] <= s*10){
                    tmpSum[u] += (emoticons[eIdx]/10)*(10-s);
                }
            }
            dfs(eIdx+1, tmpSum, users, emoticons);
        }
    }
}