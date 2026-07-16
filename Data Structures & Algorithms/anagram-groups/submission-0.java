class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> frequencyLists = new HashMap<>();
        int[] count = new int[26];
        List<Integer> keyNums = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            for(int k = 0; k < count.length; k++){
                count[k] = 0;
            }
            for(char c : strs[i].toCharArray()){
                int index = (c - 'a');
                count[index]++;
            }
            keyNums.clear();
            for(int k = 0; k < count.length; k++){
                keyNums.add(count[k]);
            }
            if(frequencyLists.containsKey(keyNums)){
                frequencyLists.get(keyNums).add(strs[i]);
            }
            else{
                List<String> current = new ArrayList<>();
                current.add(strs[i]);
                frequencyLists.put(keyNums, current);
            }
        }
        List<List<String>> output = new ArrayList<>();
        for(List<String> group: frequencyLists.values()){
            output.add(group);
        }
        return output;
    }
}
