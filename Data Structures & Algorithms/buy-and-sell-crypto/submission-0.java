class Solution {
    public int maxProfit(int[] prices) {
        
        int minValue=prices[0];
        int maxValue=0;
       for(int price:prices){
           if(minValue>price) minValue=price;
           else{
               maxValue=Math.max(maxValue,price-minValue);
           }
       }
       return maxValue;
    }
}
