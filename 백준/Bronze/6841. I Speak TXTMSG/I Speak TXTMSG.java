import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> txt=new HashMap<>();
        txt.put("CU","see you");
        txt.put(":-)","I’m happy");
        txt.put(":-(","I’m unhappy");
        txt.put(";-)","wink");
        txt.put(":-P","stick out my tongue");
        txt.put("(~.~)","sleepy");
        txt.put("TA","totally awesome");
        txt.put("CCC","Canadian Computing Competition");
        txt.put("CUZ","because");
        txt.put("TY","thank-you");
        txt.put("YW","you’re welcome");
        txt.put("TTYL","talk to you later");


        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.next();
            if(s.equals("TTYL")){
                System.out.println(txt.get(s));
                break;
            }
            else{
                System.out.println(txt.getOrDefault(s,s));
            }
        }
    }
}