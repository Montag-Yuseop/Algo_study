import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        // 1. 문자열을 각각 쪼개서 배열에 담는다
        String[] arr1 = new String[str1.length()-1];        
        String[] arr2 = new String[str2.length()-1];
        String[] arr3 = new String[str1.length()+str2.length()-2];
        
        Arrays.fill(arr1, "");
        Arrays.fill(arr2, "");
        Arrays.fill(arr3, "");
        

        for(int i = 0; i < arr1.length; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
 
            // 알파벳이 아닌 범위(아스키 코드로 바꿔서)는 continue 해버리기
            // 대문자 A는 17 ~ 42
            // 소문자 a는 49 ~ 74
            if((c1 - '0' >= 17 && c1 - '0' <= 42) || (c1 - '0' >= 49 && c1 - '0' <= 74)) {
                if((c2 - '0' >= 17 && c2 - '0' <= 42) || (c2 - '0' >= 49 && c2 - '0' <= 74)){
                    String s = str1.substring(i, i+2);
                    arr1[i] = s.toUpperCase();     
                } 
            }  
        }
        
        for(int i = 0; i < arr2.length; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
 
            // 알파벳이 아닌 범위(아스키 코드로 바꿔서)는 continue 해버리기
            // 대문자 A는 17 ~ 42
            // 소문자 a는 49 ~ 74
            if((c1 - '0' >= 17 && c1 - '0' <= 42) || (c1 - '0' >= 49 && c1 - '0' <= 74)) {
                if((c2 - '0' >= 17 && c2 - '0' <= 42) || (c2 - '0' >= 49 && c2 - '0' <= 74)){
                    String s = str2.substring(i, i+2);
                    arr2[i] = s.toUpperCase(); // 그냥 다 대문자로 바꿔버리자
                } 
            }  
        }
        
        // 2. hashmap을 만들어서 key 값과 value값의 쌍으로 만든다(중복제거)
        HashMap<String, Integer> hashmap1 = new HashMap<>();
        HashMap<String, Integer> hashmap2 = new HashMap<>();
        HashMap<String, Integer> hashmap3 = new HashMap<>();
        
        for(int i = 0; i < arr1.length; i++){
            if(!hashmap1.containsKey(arr1[i])) {
                hashmap1.put(arr1[i], 1);    
            } else {
                hashmap1.put(arr1[i], hashmap1.get(arr1[i])+1);
            }
        }
        
        for(int i = 0; i < arr2.length; i++){
            
            
            if(!hashmap2.containsKey(arr2[i])) {
                hashmap2.put(arr2[i], 1);    
            } else {
                hashmap2.put(arr2[i], hashmap2.get(arr2[i])+1);
            }
        }
        
        // 탐색을 위해 두 배열을 합쳐서 탐색용으로 쓰자
        for(int i = 0; i < arr1.length; i++ ) {
            arr3[i] = arr1[i];
        }
        for(int i = arr1.length; i < arr3.length; i++){
            arr3[i] = arr2[i-arr1.length];
        }
        
        // 3. 두 hashmap을 비교해서 같은 key값의 value값을 통해 합집합과 교집합 원소의 수를 만든다
        double small = 0;
        double big = 0;
        
        for(int i = 0; i < arr3.length; i++){
            if(arr3[i] == "") continue;
            // 두 해시맵 모두 있을 때는 교집합 처리
            if(hashmap1.containsKey(arr3[i]) && hashmap2.containsKey(arr3[i])) {
                hashmap3.put(arr3[i], Math.min(hashmap1.get(arr3[i]), hashmap2.get(arr3[i])));
            }            
        }
        
        for(int v : hashmap3.values()) {
            small += v;
        }
        // 비워주고
        hashmap3.clear();
        for(int i = 0; i < arr3.length; i++){
            if(arr3[i] == "") continue;
            // 두 해시맵 중 하나라도 있으면 값 더해주기
            if(hashmap1.containsKey(arr3[i]) && hashmap2.containsKey(arr3[i])) {
                hashmap3.put(arr3[i], Math.max(hashmap1.get(arr3[i]), hashmap2.get(arr3[i])));
            }       
            if(!hashmap1.containsKey(arr3[i]) && hashmap2.containsKey(arr3[i])){
                hashmap3.put(arr3[i], hashmap2.get(arr3[i]));
            }
            if(hashmap1.containsKey(arr3[i]) && !hashmap2.containsKey(arr3[i])){
                hashmap3.put(arr3[i], hashmap1.get(arr3[i]));
            }
        }
        
        for(int v : hashmap3.values()) {
            big += v;
        }
        
        // 4. 자카드 유사도를 출력한다
        
        if(big == 0) {
            answer = 65536;
        }
        else{
            answer = (int) Math.floor((small / big) * 65536);    
        }

        return answer;
    }
}