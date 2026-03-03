class MedianFinder {

    private Queue<Integer> minHeap; // for large elements
    private Queue<Integer> maxHeap; // for small elements

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        // balancing the 2 heaps
        if (maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty()  && maxHeap.peek() > minHeap.peek()) {
            int temp = maxHeap.poll();
            minHeap.add(temp);
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
        else if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        }else{
            return (double) minHeap.peek();
        }
    }
}
