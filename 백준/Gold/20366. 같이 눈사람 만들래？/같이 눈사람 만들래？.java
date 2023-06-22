import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 10의 9승 = 10억
        // 두개 더해도 20억, int형으로 충분하다

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = Integer.MAX_VALUE;

        // 눈덩이 배열 입력 및 정렬
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N - 3; i++) { // 2 3 5 5 9 일 경우 2, 3 (4개는 골라야 하니까) - 시작 최소 범위
            for(int j = i+3; j < N; j++ ) { // j는 5 9 (이 전에 4개는 있어야 하니까) - 바깥 최대 범위
                int start = i+1; // 안에서 움직일 애중 시작
                int end = j-1; // 안에서 움직일 애 중 끝
                while(start < end) { // 일단은 end가 더 커야함.. 줄일건데
                    int inner = arr[start] + arr[end];
                    int outer = arr[i] + arr[j];
                    answer = Math.min(answer, Math.abs(outer-inner));
                    if(inner > outer) {
                        // 안에 있는 값의 합이 바깥보다 크면?
                        end--;
                    } else {
                        start++; // 안에가 더 작으면 키워줘야지
                    }
                }

            }
        }

        System.out.println(answer);

    }
}
// 실패
// 반례
// 8
// 1 4 11 13 101 105 201 205
//        // 포인터가 4개?
//        int outerStart = 0;
//        int innerStart = 1;
//        int innerEnd = arr.length-2;
//        int outerEnd = arr.length-1;
//        // 둘 다 한칸씩 땡겨버리면 될듯?
//
//        while(innerStart < outerEnd) {
//            answer = Math.min(answer, Math.abs(arr[outerStart]+arr[outerEnd]-arr[innerStart]-arr[innerEnd]));
//            System.out.println(arr[innerStart]+" "+arr[innerEnd]);
//            System.out.println(arr[outerStart]+" "+arr[outerEnd]);
//            System.out.println();
//
//            if(Math.abs(arr[innerStart]-arr[outerStart]) < Math.abs(arr[outerEnd]-arr[innerEnd])) {
//                outerEnd--;
//                innerEnd--;
//            } else {
//                outerStart++;
//                innerStart++;
//            }
//        }