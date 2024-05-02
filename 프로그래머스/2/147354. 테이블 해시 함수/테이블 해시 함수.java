import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        // col을 기준으로 data 정렬
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int num1 = o1[col-1];
                int num2 = o2[col-1];
                int result = num1 - num2;
                
                if(result == 0) {
                    result = o2[0] - o1[0];
                }
                
                return result;
            }
            
        });
        
        // for(int[] i : data) {
        //     System.out.println(Arrays.toString(i));
        // }
        
        // int[] tempData = new int[row_end - row_begin + 1];
        int idx = 0;
        // 정렬된 data에서 row_begin과 row_end 각 값을 구한뒤 계속 xor 연산 시작
        for(int i = row_begin-1; i < row_end; i++) {
            int temp = 0;
            for(int num : data[i]) {
                temp += num % (i+1);
            }
            answer = answer ^ temp;
        }
        
        // for(int i = 0; i < tempData.length-1; i++) {
        //     answer += tempData[i] ^ tempData[i+1];
        // }
        

        
        return answer;
    }
}