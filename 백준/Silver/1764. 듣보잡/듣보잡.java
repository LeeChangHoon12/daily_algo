import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        HashMap<String,Integer> noheared = new HashMap<>();

        ArrayList<String> names = new ArrayList<>();


        for(int i=0; i<N; i++){
            noheared.put(br.readLine(),1);
        }

        //int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            String name = br.readLine();
            if(noheared.containsKey(name)){
                //cnt++;
                names.add(name);

            }
        }

        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(names.size());
        for(String name : names){
            sb.append(name + "\n");
        }
        System.out.println(sb);


    }
}
