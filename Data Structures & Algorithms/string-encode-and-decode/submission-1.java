class Solution {

    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder(); 
        for(String str: strs){
            output.append(str.length());
            output.append(",");
        }
        output.append("#");
        for(String str: strs){
            output.append(str);
        }
        return output.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int breaker = 0;
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='#'){
                breaker = i;
                break;
            }
            if(str.charAt(i)==','){
                count++;
            }
        }
        int start = 0;
        int end = 0;
        for(int i = 0; i < count; i++){
            while(str.charAt(end)!=','){
                end++;
            }
            int length = Integer.parseInt(str.substring(start, end));
            output.add(str.substring(breaker+1, breaker+length+1));
            breaker = breaker+length;
            start = end+1;
            end++;
        }
        return output;
    }
}
