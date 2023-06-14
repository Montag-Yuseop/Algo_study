import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int[][] map = new int[8][8];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int kingR = 0;
        int kingC = 0;
        int stoneR = 0;
        int stoneC = 0;

        // 왕과 돌의 위치를 정해준다
        for(int i = 0; i < 2; i++){
            String temp = st.nextToken();

            // 열은 A ~ H, 행은 1 ~ 8
            // 이것을 숫자형태로 변경
            int c = temp.charAt(0)-65;
            int r = 8-(temp.charAt(1)-48);

            if(i == 0) {
                map[r][c] = 1;
                kingR = r;
                kingC = c;
            } else {
                map[r][c] = 2;
                stoneR = r;
                stoneC = c;
            }
        }

        int N = Integer.parseInt(st.nextToken());

        // R, L, B, T, RT, LT, RB, LB 8가지 이동
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            int newKingR = kingR;
            int newKingC = kingC;
            int newStoneR = stoneR;
            int newStoneC = stoneC;

            switch(s){
                case "R" :
                    newKingC += 1;
                    if(newKingR == newStoneR && newKingC == newStoneC)
                        newStoneC += 1;

                    if(bc(newKingR, newKingC, newStoneR, newStoneC)){
                        kingC = newKingC;
                        stoneC = newStoneC;
                    }
                    break;

                case "L" :
                    newKingC -= 1;
                    if(newKingR == newStoneR && newKingC == newStoneC)
                        newStoneC -= 1;

                    if(bc(newKingR, newKingC, newStoneR, newStoneC)){
                        kingC = newKingC;
                        stoneC = newStoneC;
                    }
                    break;

                case "B" :
                    newKingR += 1;
                    if(newKingC == newStoneC && newKingR == newStoneR)
                        newStoneR += 1;

                    if(bc(newKingR, newKingC, newStoneR, newStoneC)){
                        kingR = newKingR;
                        stoneR = newStoneR;
                    }
                    break;

                case "T" :
                    newKingR -= 1;
                    if(newKingC == newStoneC && newKingR == newStoneR)
                        newStoneR -= 1;

                    if(bc(newKingR, newKingC, newStoneR, newStoneC)){
                        kingR = newKingR;
                        stoneR = newStoneR;
                    }
                    break;
                case "RT" :
                    newKingR -= 1;
                    newKingC += 1;
                    if(newKingC == newStoneC && newKingR == newStoneR){
                        newStoneR -= 1;
                        newStoneC += 1;
                    }

                    if(bc(newKingR, newKingC, newStoneR, newStoneC)){
                        kingR = newKingR;
                        kingC = newKingC;
                        stoneR = newStoneR;
                        stoneC = newStoneC;
                    }
                    break;
                case "LT" :
                    newKingR -= 1;
                    newKingC -= 1;
                    if(newKingC == newStoneC && newKingR == newStoneR){
                        newStoneR -= 1;
                        newStoneC -= 1;
                    }

                    if(bc(newKingR, newKingC, newStoneR, newStoneC)){
                        kingR = newKingR;
                        kingC = newKingC;
                        stoneR = newStoneR;
                        stoneC = newStoneC;
                    }
                    break;
                case "RB" :
                    newKingR += 1;
                    newKingC += 1;
                    if(newKingC == newStoneC && newKingR == newStoneR){
                        newStoneR += 1;
                        newStoneC += 1;
                    }

                    if(bc(newKingR, newKingC, newStoneR, newStoneC)){
                        kingR = newKingR;
                        kingC = newKingC;
                        stoneR = newStoneR;
                        stoneC = newStoneC;
                    }
                    break;
                case "LB" :
                    newKingR += 1;
                    newKingC -= 1;
                    if(newKingC == newStoneC && newKingR == newStoneR){
                        newStoneR += 1;
                        newStoneC -= 1;
                    }

                    if(bc(newKingR, newKingC, newStoneR, newStoneC)){
                        kingR = newKingR;
                        kingC = newKingC;
                        stoneR = newStoneR;
                        stoneC = newStoneC;
                    }
                    break;
            }

        }
        System.out.println((char) (kingC+65)+""+(8-kingR));
        System.out.println((char) (stoneC+65)+""+(8-stoneR));

    }

    private static boolean bc(int kingR, int kingC, int stoneR, int stoneC) {
        return kingR >= 0 && kingC >= 0 && stoneR >= 0 && stoneC >=0 &&
                kingR < 8 && kingC < 8 && stoneR < 8 && stoneC < 8;
    }
}