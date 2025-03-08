import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> m = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(m.containsKey(num)){
                m.put(num, m.get(num)+1);
            }else{
                m.put(num,1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<M; i++){
            //System.out.print(m.getOrDefault(Integer.parseInt(st.nextToken()),0)+ " ");
            sb.append(m.getOrDefault(Integer.parseInt(st.nextToken()),0)+ " ");
        }
        System.out.print(sb);
    }
}
