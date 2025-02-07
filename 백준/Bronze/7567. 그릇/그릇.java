import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int cnt = 10;
        for(int i=0; i<line.length()-1;i++){
            if(line.charAt(i) == line.charAt(i+1)){
                cnt += 5;
            }else{
                cnt += 10;
            }
        }

        System.out.println(cnt);
    }
}
