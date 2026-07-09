class KthLargest {
  private  int k;
   private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        minHeap=new PriorityQueue<>();
        this.k=k;
        for(int num:nums){
            
                minHeap.offer(num);
            
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.offer(val);
            return minHeap.peek();
        }

         minHeap.offer(val);
         minHeap.poll();
         return minHeap.peek();
    }
}
