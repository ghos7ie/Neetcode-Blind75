class KthLargest {
    PriorityQueue<Integer> minHeap;
    int maxSize;


    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<Integer>();
        this.maxSize = k;
        for (int i = 0; i < nums.length; i++) {
            this.minHeap.add(nums[i]);
            if (this.minHeap.size() > this.maxSize) {
                this.minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > this.maxSize) {
            minHeap.poll();
        }
        return this.minHeap.peek();
    }
}
