import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {     
        // map을 사용, map에는 String, ArrayList 형태로 저장
        
//         Map<String, ArrayList<Integer>> map = new HashMap();
        
//         for(int i = 0; i < genres.length; i++) {
//             if(!map.containsKey(genres[i])) {
//                 ArrayList<Integer> list = new ArrayList();
//                 list.add(plays[i]);
//                 list.add(0,plays[i]);
//                 map.put(genres[i], list); 
//             } else {
//                 ArrayList<Integer> list = map.get(genres[i]);
//                 list.add(plays[i]);
//                 int temp = list.get(0) + plays[i];
//                 list.remove(0);
//                 list.add(0, temp);
//                 map.put(genres[i], list);
//             }
//         }
        
//         HashMap<Integer, int[]> album = new HashMap();
        
//         for(String s : map.keySet()) {
//             ArrayList<Integer> list = map.get(s);
//             Collections.sort(list, Collections.reverseOrder());
//             int[] temp = new int[2];
//             if(list.size() >= 3) {
//                 temp[0] = list.get(1);
//                 temp[1] = list.get(2);
//             } else {
//                 temp[0] = list.get(1);
//                 temp[1] = -1;
//             }
            
//             album.put(list.get(0), temp);
            
            
            
//             System.out.println(Arrays.toString(temp));
//         }
        
//         System.out.println(map);
        
        
        HashMap<String, Integer> sum = new HashMap(); // 장르별 시간
        HashMap<String, HashMap<Integer,Integer>> music = new HashMap(); 
        
        for(int i = 0; i < plays.length; i++) {
            if(!sum.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                sum.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                sum.put(genres[i], sum.get(genres[i]) + plays[i]);
            }
            
        }
        
        List<String> keySet = new ArrayList(sum.keySet());
        Collections.sort(keySet, (s1, s2) -> sum.get(s2) - (sum.get(s1)));
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());
 
            Collections.sort(genre_key, (s1, s2) -> map.get(s2) - (map.get(s1)));
 
            answer.add(genre_key.get(0));
            if(genre_key.size() > 1)
                answer.add(genre_key.get(1));
        }
        
        
        return answer;
    }
}