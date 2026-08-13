class Solution {
    public List<String> letterCombinations(String digits) {
      List<String> result=new ArrayList<>();
      if(digits==null || digits.length()==0){
        return result;
      }
      String[] phone={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
      backtrack(digits,0,new StringBuilder(),phone,result);
      return result;  
    }
    private void backtrack(String digits,int index,StringBuilder path,String[] phone,  List<String> result){
        if(path.length()==digits.length()){
            result.add(path.toString());
            return;
        }
        String letters=phone[digits.charAt(index)-'0'];
        for(char c:letters.toCharArray()){
            path.append(c);
            backtrack(digits,index+1,path,phone,result);
            path.deleteCharAt(path.length()-1);
        }
    }
}
