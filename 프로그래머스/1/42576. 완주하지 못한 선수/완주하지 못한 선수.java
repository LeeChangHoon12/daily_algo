import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        
        Map<String,Integer> people = new HashMap<String,Integer>();
        
        for(int i=0; i<participant.length; i++){
            if(people.containsKey(participant[i])){
                people.put(participant[i], people.get(participant[i]) + 1);
            }else{
                people.put(participant[i],1);
            }
        }
        
        for(int i=0; i<completion.length; i++){
            if(people.containsKey(completion[i])){
                 people.put(completion[i], people.get(completion[i])-1);
            }
           
        }
        
        for(String key : people.keySet()){
            if(people.get(key) != 0){
                return key;
            }
        }
        
        return "";
        
    }
}