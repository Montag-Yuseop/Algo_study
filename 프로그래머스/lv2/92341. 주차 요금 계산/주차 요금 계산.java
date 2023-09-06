import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {

        int time = fees[0]; // 기본 시간
        int fee = fees[1]; // 기본 요금
        int over_time = fees[2]; // 추가 시간
        int over_fee = fees[3]; // 추가 시간 당 요금
        HashMap<String, String[]> map = new HashMap();
        
        // 차량을 쪼개면서 비교하자
        for(int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            String temp = st.nextToken(); // 시간 임시 저장
            String car_num = st.nextToken(); // 차 번호
            String in_out = st.nextToken(); // 출입현황
            st = new StringTokenizer(temp, ":");
            String hour = st.nextToken(); // 현재 시간
            String minute = st.nextToken(); // 현재 분
            String total_time = "0";
            
            // map에 차 번호가 없을 경우(초기값 설정)
            if(!map.containsKey(car_num)) {
                // IN 입력, 시간, 분, 기본 요금 저장
                String[] arr = {"IN", hour, minute, String.valueOf(fee), total_time};
                map.put(car_num, arr);
                // System.out.println(car_num +": "+Arrays.toString(map.get(car_num)));
            } else {
                // 차 번호가 있을 경우
                // IN이냐 OUT이냐로 일단 나눔
                if(in_out.equals("IN")) { // 들어온 차
                    // 그냥 최신화
                    String temp_fee = map.get(car_num)[3];
                    String to = map.get(car_num)[4];
                    String[] arr = {"IN", hour, minute, temp_fee, to};
                    map.put(car_num, arr);
                    // System.out.println(car_num +": "+Arrays.toString(map.get(car_num)));
                } else {
                    // 나가는 차
                    // 계산해주기
                    int before_hour = Integer.parseInt(map.get(car_num)[1]);
                    int before_minute = Integer.parseInt(map.get(car_num)[2]);
                    int before_fee = Integer.parseInt(map.get(car_num)[3]);
                    int before_time = Integer.parseInt(map.get(car_num)[4]);
                    
                    int now_hour = Integer.parseInt(hour);
                    int now_minute = Integer.parseInt(minute);
                    
                    int charge = before_fee;
                    int sum = 0;
                    
                    sum = before_time + 60*(now_hour-before_hour) + (now_minute - before_minute);
                    if(sum > time) {
                        charge += (Math.ceil(sum/over_time)) * over_fee;
                    } else {
                        charge = before_fee;
                    }

                    
                    // System.out.println(charge);
                    
                    String[] arr = {"OUT", hour, minute, String.valueOf(charge), String.valueOf(sum)};
                    map.put(car_num, arr);
                }
                
            }
            // System.out.println(car_num +": "+Arrays.toString(map.get(car_num)));
        }
        
        String[] car_number = new String[map.size()];
        int[] answer = new int[map.size()];
        int idx = 0;
        
        for(String carnum : map.keySet()) {
            car_number[idx++] = carnum;
            
            if(map.get(carnum)[0].equals("IN")) {
                // 입차 후 출차 기록이 없으면 요금 추가
                int last_hour = Integer.parseInt(map.get(carnum)[1]);
                int last_minute = Integer.parseInt(map.get(carnum)[2]);
                int temp_sum = Integer.parseInt(map.get(carnum)[4]) + 60*(23-last_hour)+ 59 - last_minute;
                String[] temp_array = {"OUT", map.get(carnum)[1], map.get(carnum)[2], map.get(carnum)[3], String.valueOf(temp_sum)};
                map.put(carnum, temp_array);
            }
            
            System.out.println(carnum +" "+ Arrays.toString(map.get(carnum)));
        }
        
        Arrays.sort(car_number);
        for(int i = 0; i < car_number.length; i++) {
            double count = Integer.parseInt(map.get(car_number[i])[4]);
            answer[i] = fee;
            count = count - time;
            answer[i] += Math.ceil(count/(double) over_time)*over_fee;
            if(count <= 0) answer[i] = fee;
        }
        
        
        return answer;
    }
}