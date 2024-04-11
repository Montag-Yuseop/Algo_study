import java.util.*;

class Solution {
    static int sort_idx;
    
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        
        // 코드번호, 제조일, 최대 수량, 현재 수량
        
        // ext: 정렬 기준
        int ext_idx = 0;
        if(ext.equals("date")) ext_idx = 1;
        else if(ext.equals("maximum")) ext_idx = 2;
        else if(ext.equals("remain")) ext_idx = 3;
        
        // val_ext: 정보 기준 값
        
        
        // sort_by: 정렬 기준 문자열
        sort_idx = 0;
        if(sort_by.equals("date")) sort_idx = 1;
        else if(sort_by.equals("maximum")) sort_idx = 2;
        else if(sort_by.equals("remain")) sort_idx = 3;
        
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[sort_idx] - o2[sort_idx];
            }    
        });
        
        for(int[] i : data) {
            if(i[ext_idx] >= val_ext) continue;
            
            answer.add(i);
        }
        
        
        return answer;
    }
}