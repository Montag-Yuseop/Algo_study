import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트 케이스의 수
        int N = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < N; tc++) {
            String s = br.readLine();
            LinkedList<Character> password = new LinkedList<>();
            ListIterator<Character> iter = password.listIterator();

            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                switch(c) {
                    case '<' :
                        if(iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '>' :
                        if(iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-' :
                        if(iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                }
            }

            for (char c : password) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}