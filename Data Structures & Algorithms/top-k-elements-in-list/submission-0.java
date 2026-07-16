class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int num :nums){
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] buckets = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry: counts.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if(buckets[count] == null){
                buckets[count] = new ArrayList<>();
            }
            buckets[count].add(num);
        }
        int[] result = new int[k];
        int total = 0;
        for(int n = buckets.length - 1; n>=0; n--){
            if(buckets[n]==null){
                continue;
            }
            for(int current : buckets[n]){
                result[total] = current;
                total++;

                if(total == k){
                    return result;
                }
            }
        }
        return result;
    }
}
