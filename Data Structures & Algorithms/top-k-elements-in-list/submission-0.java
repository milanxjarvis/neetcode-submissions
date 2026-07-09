class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer,Integer> freq =new HashMap<>();
        for(int num:nums){
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        List<Integer>[] buckets=new List[nums.length+1];
        for(int i:freq.keySet()){
            int f=freq.get(i);
            if(buckets[f]==null) buckets[f]=new ArrayList<>();
            buckets[f].add(i);
        }
        int[] result=new int[k];
        int idx=0;
        for(int i= buckets.length-1;i>=1&&idx<k;i--){
        if(buckets[i]!=null){
            for(int num:buckets[i]){
                result[idx++]=num;
                if(idx==k) break;
            }
        }
        }
        return result;  
    }
}
