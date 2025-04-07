import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] d = new int[N+1];
        int[] preNode = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);

        List<ArrayList<Node>> graph = new ArrayList<>();
        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to,weight));

        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());


        d[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(now.weight > d[now.v]){
                continue;
            }

            for(Node next : graph.get(now.v)){
                int nextV = next.v;
                int nextW = next.weight + now.weight;

                if(nextW < d[nextV]){
                    d[nextV] = nextW;
                    pq.add(new Node(nextV, nextW));
                    preNode[nextV] = now.v;
                }
            }
        }

        System.out.println(d[end]);

        Stack<Integer> stack = new Stack<>();
        stack.push(end);

        int cnt = 0;
        while(preNode[end] != 0){
            cnt+=1;
            stack.push(preNode[end]);
            end = preNode[end];
        }
        System.out.println(cnt + 1);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }




    }

    static class Node implements Comparable<Node>{
        int v;
        int weight;

        public Node(int v, int weight){
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }


    }
}
