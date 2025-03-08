import java.util.*;
import java.io.*;

public class Solution {
    static int[] inDegree;
    static ArrayList<Integer>[] graph;
    static Queue<Integer> queue;
    static int V, E;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        // 한 번만 BufferedReader를 생성하여 모든 테스트케이스에서 재사용


        for (int tc = 1; tc <= 10; tc++) {
            input();  // BufferedReader를 인자로 넘겨 재사용

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");

            queue = new ArrayDeque<>();
            // 진입차수가 0인 노드를 큐에 넣기
            for (int i = 1; i <= V; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }

            // 위상정렬 수행: 큐에서 꺼낼 때마다 출력 문자열에 추가
            while (!queue.isEmpty()) {
                int from = queue.poll();
                sb.append(from).append(" ");
                for (int to : graph[from]) {
                    if (--inDegree[to] == 0) {
                        queue.offer(to);
                    }
                }
            }

            System.out.println(sb);
        }
    }

    static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        inDegree = new int[V + 1];
        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < E; i++) {
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            inDegree[to]++;
        }
    }
}
