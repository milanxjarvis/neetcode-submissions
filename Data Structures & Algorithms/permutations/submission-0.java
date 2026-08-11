class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums,0,new ArrayList<>(),result);
        return result;
    }
    private void backtrack(int[] nums,int start,List<Integer> temp,List<List<Integer>> result){
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(temp.contains(nums[i])) continue;
            
            temp.add(nums[i]);
            backtrack(nums,i+1,temp,result);
            temp.remove(temp.size()-1);
            
        }
        
    }
}
