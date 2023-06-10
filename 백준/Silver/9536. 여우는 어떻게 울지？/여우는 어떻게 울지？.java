import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());

            String[] cry = new String[st.countTokens()];


            for(int i = 0; i < cry.length; i++){
                cry[i] = st.nextToken();
            }

            while(true){
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                if(s.equals("what")){
                    break;
                } else{
                    for(int i = 0; i < 2; i++){
                        s = st.nextToken();
                    }

                    for(int i = 0; i < cry.length; i++){
                        if(cry[i].equals(s)){
                            cry[i] = "";
                        }
                    }
                }
            }
            for(int i = 0; i < cry.length; i++){
                if(!cry[i].equals("")){
                    sb.append(cry[i] + " ");
                }
            }
            System.out.println(sb);
        }
    }
}