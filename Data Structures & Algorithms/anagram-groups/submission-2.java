class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for(String str: strs){
            Map<Character, Integer> charMap = new HashMap<>();
            for(char c: str.toCharArray()){
                charMap.put(c, charMap.getOrDefault(c,0)+1);
            }
            if(!map.containsKey(charMap)){
                map.put(charMap, new ArrayList<>());
            }
            map.get(charMap).add(str);
        }
        List<List<String>> output = new ArrayList<>();
        for(List<String> val : map.values()){
            output.add(val);
        }
        return output;
    }
}
