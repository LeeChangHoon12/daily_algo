import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int shop = Integer.parseInt(br.readLine());
        int[] dir = new int[shop];
        int[] len = new int[shop];

        for(int i=0; i<shop; i++){
            st = new StringTokenizer(br.readLine());

            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());

        }
        st = new StringTokenizer(br.readLine());
        int startDir = Integer.parseInt(st.nextToken());
        int startLen = Integer.parseInt(st.nextToken());

        int min = 0;
        for(int i=0; i<shop; i++){

            //상점 dir와 시작dir이 같을 때,
            if(dir[i] == startDir){
                min+= Math.abs(startLen - len[i]);
            // 북쪽, 남쪽에서 마주보고 있는 경우
            }else if((dir[i] == 1 && startDir == 2) || (dir[i] == 2 && startDir == 1)){

                min += Math.min(len[i] + height + startLen, width - len[i] + height + width - startLen);

            // 동쪽, 서쪽에서 마주보고 있는 경우
            }else if((dir[i] == 3 && startDir == 4) || (dir[i] == 4 && startDir == 3)){
                min += Math.min(len[i] + width + startLen, height - len[i] + width + height - startLen);
            }else{

                if(startDir == 1){
                    //북에서 동
                    if(dir[i] == 4){
                        min += (width-startLen + len[i]);

                    //북에서 서
                    }else if(dir[i] == 3){
                        min += (startLen + len[i]);
                    }
                }else if(startDir == 2){
                    //남에서 서
                    if(dir[i] == 3){
                        min += startLen + height-len[i];
                    //남에서 동
                    }else if(dir[i] == 4){
                        min += width-startLen + height-len[i];
                    }
                }else if(startDir == 4) {
                    //동에서 북
                    if (dir[i] == 1) {
                        min += startLen + width-len[i];

                    //동에서 남
                    } else if (dir[i] == 2) {
                        min += height - startLen + width - len[i];
                    }
                }else if(startDir == 3) {
                    //서에서 북
                    if (dir[i] == 1) {
                        min += startLen + len[i];
                    //서에서 남
                    } else if (dir[i] == 2) {
                        min += height-startLen + len[i];
                    }
                }
            }


        }

        System.out.println(min);

    }
}
