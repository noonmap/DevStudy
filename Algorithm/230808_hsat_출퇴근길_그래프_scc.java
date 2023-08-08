import java.util.*;
import java.io.*;


public class Main
{
    static int N, M; // 정점, 간선 개수
    static int S, T;
    static List<Integer>[] graph;
    static List<Integer>[] graphR;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        graphR = new ArrayList[N+1];
        for(int i=1; i<N+1; i++) graph[i] = new ArrayList<>();
        for(int i=1; i<N+1; i++) graphR[i] = new ArrayList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graphR[y].add(x);
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        boolean[] visitS = new boolean[N+1];
        boolean[] visitT = new boolean[N+1];
        boolean[] visitR = new boolean[N+1];

        // 출근길 순방향 dfs
        visitS[T] = true;
        dfs(S, visitS, graph);

        // 퇴근길 순방향 dfs
        visitT[S] = true;
        dfs(T, visitT, graph);

        // 출근길&퇴근길 역방향 dfs : S -> T -> S를 검사
        dfs(T, visitR, graphR);

        int res = 0;
        for(int i=1; i<=N; i++){
            // 출근길 순방향 == 출근길 역방향 == true : 출근길에 포함
            // 퇴근길 순방향 == 퇴근길 역방향 == true : 퇴근길에 포함            
            if(visitS[i] && visitT[i] && visitR[i]) res++;
        }
        System.out.println(res-2); // S, T제외외
    }
    public static void dfs(int cur, boolean[] visit, List<Integer>[] adj){
        if(visit[cur] == true) return;
        visit[cur] = true;

        for(int nxt : adj[cur]){
            dfs(nxt, visit, adj);
        }
    }
}