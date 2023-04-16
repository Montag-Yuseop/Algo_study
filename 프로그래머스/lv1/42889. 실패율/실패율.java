import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] sum = new int[N+1];
        int[] count = new int[N+1]; // N+1 은 N스테이지까지 클리어한 사람이 있음
        
        ArrayList<double[]> list = new ArrayList<>();
        
        for(int i = 0; i < stages.length; i++) {
            count[stages[i]-1]++;
        }
        
        sum[0] = stages.length;
        for(int i = 1; i < N+1; i++){
            sum[i] = sum[i-1] - count[i-1];
        }
    
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(sum));
            
        
        for(int i =0; i < N; i++){
            if(sum[i] == 0 ){
                list.add(new double[] {i+1, 0});
            } else{
                list.add(new double[] {i+1, (double) count[i]/(double) sum[i]}) ;   
            }
        }
        
        list.sort((a,b) -> Double.compare(b[1],a[1]));
        for(int i = 0; i < list.size(); i++){
            answer[i] = (int) list.get(i)[0];
        }
        
        return answer;
    }
}