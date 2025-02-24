
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /*
            3 2 1
            1 2
            1 3
    */
    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Integer>> graph;
    static int node,edge,start;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] arg ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start= Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        //그래프 초기화
        initGraph(node);


        //양방향 간선 추가
        for(int i=0; i<edge; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(str.nextToken());
            int v = Integer.parseInt(str.nextToken());

            addEdge(u,v);
        }

        /****중요조건 : 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문 ***/
        for(int i=0;i<node+1;i++){
            Collections.sort(graph.get(i));
        }

        boolean[] visited_dfs = new boolean[node+1];
        //깊이 우선 탐색
        dfs(start,visited_dfs);

        sb.append("\n");

        //넓이 우선 탐색
        bfs(start);
        System.out.println(sb);

    }

    public static void initGraph(int node){
        for(int i=0; i<node+1; i++){
            graph.add(i,new ArrayList<Integer>());
        }
    }
    public static void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void dfs(int u, boolean[] visited){

        visited[u] = true;
        sb.append(u + " ");

        for(int t: graph.get(u)){
            if(!visited[t]){
                dfs(t,visited);
            }
        }
    }

    public static void bfs(int start){

        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[node+1];

        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int u = queue.poll();
            sb.append(u + " ");

            for(int t : graph.get(u)){
                if(!visited[t]){
                    queue.add(t);
                    visited[t] = true;
                }

            }
        }

    }
}
