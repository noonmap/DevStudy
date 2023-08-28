import java.util.*;

class Solution {
    static class Term{
        char term;
        int duration;
        public Term(char t, int d){
            term = t; duration = d;
        }
    }
    static class Privacy{
        int year;
        int mon;
        int day;
        char term;
        public Privacy(String d, char t){
            StringTokenizer st = new StringTokenizer(d, ".");
            year = Integer.parseInt(st.nextToken());
            mon = Integer.parseInt(st.nextToken());
            day = Integer.parseInt(st.nextToken());
            term = t;
        }
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st = new StringTokenizer(today, ".");
        
        int year = Integer.parseInt(st.nextToken());
        int mon = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        
        int[] termsInfo = new int['Z'-'A'+1];
        Privacy[] privaciesInfo = new Privacy[privacies.length];
        for(int i=0; i<terms.length; i++){
            st = new StringTokenizer(terms[i]);
            termsInfo[st.nextToken().charAt(0)-'A'] = Integer.parseInt(st.nextToken());
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            st = new StringTokenizer(privacies[i]);
            Privacy p = new Privacy(st.nextToken(), st.nextToken().charAt(0));
            p.mon += termsInfo[p.term-'A'];
            while(p.mon > 12){
                p.year++;
                p.mon-=12;
            }
            if(p.year < year 
               || (p.year == year && p.mon < mon) 
               || (p.year == year && p.mon == mon && p.day <= day)){
                ans.add(i+1);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}