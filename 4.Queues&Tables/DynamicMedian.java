import java.util.PriorityQueue;

// Design a data type that supports 
//insert in logarithmic time, 
//find-the-median in constant time
//remove-the-median in logarithmic time. 
//If the number of keys in the data type is even: find/remove the lower median.

public class DynamicMedian{
  private  PriorityQueue<Integer> minHeap = 
    new PriorityQueue<Integer>();
private  PriorityQueue<Integer> maxHeap = 
    new PriorityQueue<Integer>((o1,o2)-> o2-o1);

    public void insert(int element){
      float median = median();
      if(element > median){
        minHeap.add(element);
      }else{
        maxHeap.add(element);
      }
      balaceHeap();
    }

    public float median(){
      int minSize = minHeap.size();
      int maxSize = maxHeap.size();
      if(maxSize == 0 && minSize == 0){
        return 0;
      }

      if(maxSize > minSize){
        return maxHeap.peek();
      }

      if(minSize > maxSize){
        return minHeap.peek();
      }

      return (maxHeap.peek() + minHeap.peek()) / 2f;
    }

    public void remove(){
      int minSize = minHeap.size();
      int maxSize = maxHeap.size();

      if(maxSize > minSize){
        maxHeap.pop();
      }else{
        minHeap.pop();
      }
    }
    private void balaceHeap(){
      int minSize = minHeap.size();
      int maxSize = maxHeap.size();
      int temp = 0;
      if(minSize > maxSize + 1){
        tmp = minHeap.poll();
        maxHeap.offer(tmp);
      }

      if(maxSize > minSize + 1){
        tmp = maxHeap.poll();
        minHeap.offer(tmp);
      }
    }

}