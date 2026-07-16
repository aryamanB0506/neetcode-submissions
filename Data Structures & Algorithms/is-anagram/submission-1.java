class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for(char c : s.toCharArray()){
            counts.put(c, counts.getOrDefault(c, 0)+1);
        }
        for(char b : t.toCharArray()){
            if(counts.containsKey(b)){
                if(counts.get(b)==1){
                    counts.remove(b);
                }
                else{
                    counts.put(b, counts.get(b) - 1);    
                }
            }
            else{
                return false;
            }
        }
        if(!counts.isEmpty()){
            return false;
        }
        return true;
    }
}
