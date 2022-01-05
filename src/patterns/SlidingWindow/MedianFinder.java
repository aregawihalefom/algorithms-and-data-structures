package patterns.SlidingWindow;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    private PriorityQueue<Integer> minHeap , maxHeap;

    public MedianFinder(){
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num){

        // Max heap should be greater than max heap
        if(minHeap.size() == maxHeap.size()){
            minHeap.add(num);
            maxHeap.add(minHeap.remove());
        }else{
            maxHeap.add(num);
            minHeap.add(maxHeap.remove());
        }
    }

    public double findMedian(){

        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }

}
