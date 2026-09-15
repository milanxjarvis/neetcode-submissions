class Solution {
    public String longestPalindrome(String s) {
      int maxLength=1;
      int start=0;
      for(int i=0;i<s.length();i++){
        int ln1=expand(s,i,i);
        int ln2=expand(s,i,i+1);
        int ln=Math.max(ln1,ln2);
        if(ln>maxLength){
          maxLength=ln;
          start=i-(maxLength-1)/2;  
        }
      }
      return s.substring(start,start+maxLength);
    }
    private int expand(String s,int left,int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
