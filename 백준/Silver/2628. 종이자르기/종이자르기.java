import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int width;
    static int height;
    static boolean[] widthArr;
    static boolean[] heightArr;
    static int cut;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        widthArr = new boolean[width+1];
        heightArr = new boolean[height+1];

        cut = Integer.parseInt(br.readLine());

        for(int c=0; c<cut; c++){
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(dir == 0){
                heightArr[num] = true;
            }else{
                widthArr[num] = true;
            }
        }

        int count = 0;
        List<Integer> heightResult = new ArrayList<>();
        for(int i=1; i<height; i++){
            if(heightArr[i]){
                count++;
                heightResult.add(count);
                count = 0;
            }else{
                count++;
            }
        }
        count++;
        heightResult.add(count);


        count = 0;
        List<Integer> widthResult = new ArrayList<>();
        for(int i=1; i<width; i++){
            if(widthArr[i]){
                count++;
                widthResult.add(count);
                count = 0;
            }else{
                count++;
            }
        }
        count++;
        widthResult.add(count);

        Collections.sort(heightResult);
        Collections.sort(widthResult);
        System.out.println(heightResult.get(heightResult.size()-1)*widthResult.get(widthResult.size()-1));
    }


}

// 0 0 t t 0 0 0 0 0 0 0 0
// 0 0 0 0 t 0 0 0 0 0