class Solution {
    public String solution(String phone_number) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        for(int i=0; i<phone_number.length() -4; i++){
            sb.append("*");
        }
        
        sb.append(phone_number.substring(phone_number.length()-4));
        
        return sb.toString();
    }
}