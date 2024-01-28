import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] card;

    public static void main(String[] args) throws IOException {

        // a케이크b = a.z + b.x, a.y * b.y, a.x + b.z;
        // a.z + b.x = c.x;
        // a.y * b.y = c.y;
        // a.x + b.z = c.z;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int ax = Integer.parseInt(st.nextToken());
        int ay = Integer.parseInt(st.nextToken());
        int az = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int cz = Integer.parseInt(st.nextToken());

        int bx = cx - az;
        int by = cy / ay;
        int bz = cz - ax;

        System.out.println(bx +" " + by +" "+ bz);



    }



}